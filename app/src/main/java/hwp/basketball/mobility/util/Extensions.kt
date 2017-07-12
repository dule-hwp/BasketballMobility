package hwp.basketball.mobility.util

import android.graphics.*
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 *
 * This file contains all of the extension functions used in the project.
 *
 */

/**
 * Used for displaying toasts from within activity objects.
 *
 * */
fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Used for displaying toasts from within fragment objects.
 *
 * @sample sampleToast
 * */
fun Fragment.toast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

/**Path "Line to point" extension function.
 * Instead of to x and y coordinates.
 * @sample hwp.basketball.mobility.drill.perform.sketchview.SensorDrawingView.getAngleLengthForSegmentIndex
 * */
fun Path.lineTo(point: PointF) = this.lineTo(point.x, point.y)

/**
 *
 * Set the beginning of the next contour to the [PointF] point.
 *
 * Path "Move to point" extension function.
 * Instead of to x and y coordinates.
 * @param
 * @sample hwp.basketball.mobility.drill.perform.sketchview.SensorDrawingView.getAngleLengthForSegmentIndex
 * */
fun Path.moveTo(point: PointF) = this.moveTo(point.x, point.y)

fun Canvas.drawCircle(point: PointF, radius: Float, paint: Paint) =
        this.drawCircle(point.x, point.y, radius, paint)

fun Canvas.drawLine(start: Point, end: Point, paint: Paint) =
        this.drawLine(start.x.toFloat(), start.y.toFloat(), end.x.toFloat(), end.y.toFloat(), paint)

/**
 * Pins distance to 0 <= distance <= getLength(), and then computes the
 * corresponding position. Returns false if there is no path,
 * or a zero-length path was specified, in which case position is unchanged.
 *
 * @param distance The distance along the current contour to sample
 * @param point returns the sampled position point
 * @return false if there was no path associated with this measure object
 *
 * @sample sampleGetPointAtDistance
 * */
fun PathMeasure.getPointAtDistance(distance: Float, point: PointF): Boolean {
    val nextPoint = FloatArray(2)
    val res = this.getPosTan(distance, nextPoint, null)
    point.x = nextPoint[0]
    point.y = nextPoint[1]
    return res
}
/**
 * Type safe find view by id replacement.
 * It is being called only once and then the value is being read next time.
 * Much more convenient then having to have a field initialized in onCreate,
 * can be used while declaring the property.
 *
 * @param T type for safe cast. If cast unsuccessful throws exception in this case, can be changed
 * to return nullable value.
 *
 * Usage:
 * @sample sampleActivityBind
 * */
fun <T : Any> AppCompatActivity.bindView(viewId: Int) = Binder<T>(viewId, this)
class Binder<out T : Any>(val viewId: Int, val activity: AppCompatActivity) : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = activity.findViewById(viewId) as? T
        }
        return value ?: throw UninitializedPropertyAccessException("Uninitialized ${property.name}")
    }
}

/**
 * Type safe find view by id replacement.
 * It is being called only once and then the value is being read next time.
 * Much more convenient then having to have a field initialized in onCreate,
 * can be used while declaring the property.
 *
 * @param T type for safe cast. If cast unsuccessful throws exception in this case, can be changed
 * to return nullable value.
 *
 * Usage:
 * @sample sampleViewBind
 * */

fun <T : Any> View.bindView(viewId: Int) = ViewBinder<T>(viewId, this)
class ViewBinder<out T : Any>(val viewId: Int, val view: View) : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = view.findViewById(viewId) as? T
        }
        return value ?: throw UninitializedPropertyAccessException("Uninitialized ${property.name}")
    }
}

/**
 * Firebase has certain characters which cannot be used as part of the key.
 * I wanted to organize data to be more browsable, and wanted to use email as key,
 * so i had to replace '.' with ',' and then used that value as key for users.
 *
 * @return Firebase user email whre '.' is replaced with ','
 * */
fun FirebaseUser.getFireBaseDBEmail(): String {
    return this.email?.replace(".", ",", true) ?: "unknown_email"
}
