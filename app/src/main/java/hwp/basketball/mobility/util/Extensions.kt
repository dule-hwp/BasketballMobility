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
 * Created by dusan_cvetkovic on 6/26/17.
 */


fun AppCompatActivity.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(message: String) {
    Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
}

fun Path.lineTo(point: PointF) = this.lineTo(point.x, point.y)
fun Bitmap.getPixel(point: Point) = this.getPixel(point.x, point.y)
fun Path.moveTo(point: PointF) = this.moveTo(point.x, point.y)

fun Canvas.drawCircle(point: PointF, radius: Float, paint: Paint) =
        this.drawCircle(point.x, point.y, radius, paint)

fun Canvas.drawLine(start: Point, end: Point, paint: Paint) =
        this.drawLine(start.x.toFloat(), start.y.toFloat(), end.x.toFloat(), end.y.toFloat(), paint)

fun PathMeasure.getPointAtDistance(distance: Float, point: PointF): Boolean {
    val nextPoint = FloatArray(2)
    val res = this.getPosTan(distance, nextPoint, null)
    point.x = nextPoint[0]
    point.y = nextPoint[1]
    return res
}

fun <T : Any> AppCompatActivity.bindView(viewId: Int) = Binder<T>(viewId, this)
class Binder<out T : Any>(val viewId: Int, val activity: AppCompatActivity) : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = activity.findViewById(viewId) as? T
        }
        return value?: throw UninitializedPropertyAccessException("Uninitialized ${property.name}")
    }
}

fun <T : Any> View.bindView(viewId: Int) = ViewBinder<T>(viewId, this)
class ViewBinder<out T : Any>(val viewId: Int, val view: View) : ReadOnlyProperty<Any?, T> {
    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (value == null) {
            value = view.findViewById(viewId) as? T
        }
        return value?: throw UninitializedPropertyAccessException("Uninitialized ${property.name}")
    }
}

fun FirebaseUser.getFireBaseDBEmail(): String {
    return this.email?.replace(".", ",", true) ?: "unknown_email"
}
