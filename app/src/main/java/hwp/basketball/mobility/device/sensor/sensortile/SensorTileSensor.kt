package hwp.basketball.mobility.device.sensor.sensortile

import android.content.Context
import android.content.SharedPreferences
import android.hardware.SensorManager
import com.st.BlueSTSDK.Feature
import com.st.BlueSTSDK.Features.FeatureAcceleration
import com.st.BlueSTSDK.Features.FeatureGyroscope
import com.st.BlueSTSDK.Features.FeatureMagnetometer
import com.st.BlueSTSDK.Manager
import com.st.BlueSTSDK.Node
import hwp.basketball.mobility.device.sensor.BaseSensor
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 3/4/17.
 */

class SensorTileSensor(val stateListener: SensorStateChangedCallback, val context: Context, val prefs: SharedPreferences)
    : BaseSensor(), Feature.FeatureListener, Node.NodeStateListener {

    override fun getSharedPrefs(): SharedPreferences {
        return prefs
    }

    override fun subscribeToMagnetometerChange() {
        val featureMagnetometer = node?.getFeature(FeatureMagnetometer::class.java)
        featureMagnetometer?.addFeatureListener(this)
        node?.enableNotification(featureMagnetometer)
    }

    override fun unSubscribeFromMagnetometerChange() {
        val featureMagnetometer = node?.getFeature(FeatureMagnetometer::class.java)
        featureMagnetometer?.removeFeatureListener(this)
        node?.disableNotification(featureMagnetometer)
    }

    override fun subscribeToAccChange() {
        val featureAcceleration = node?.getFeature(FeatureAcceleration::class.java)
        featureAcceleration?.addFeatureListener(this)
        node?.enableNotification(featureAcceleration)
    }

    override fun unSubscribeFromAccChange() {
        val featureAcceleration = node?.getFeature(FeatureAcceleration::class.java)
        featureAcceleration?.removeFeatureListener(this)
        node?.disableNotification(featureAcceleration)
    }

    override fun subscribeToGyroChange() {
        val featureAcceleration = node?.getFeature(FeatureGyroscope::class.java)
        featureAcceleration?.addFeatureListener(this)
        node?.enableNotification(featureAcceleration)
    }

    override fun unSubscribeFromGyroChange() {
        val featureAcceleration = node?.getFeature(FeatureGyroscope::class.java)
        featureAcceleration?.removeFeatureListener(this)
        node?.disableNotification(featureAcceleration)
    }

    override fun getName(): String {
        return SensorTileSensor::class.java.simpleName
    }

    private var node: Node? = null

    override fun connectTo(deviceID: String) {
        node = Manager.getSharedInstance().getNodeWithTag(deviceID)
        node?.let {
            if (!it.isConnected) {
                it.addNodeStateListener(this)
                it.connect(context)
            }
        }
    }

    override fun disconnect() {
//        magnetometerListener = null
        node?.disconnect()
    }

    override fun isConnectable(): Boolean {
        return true
    }

    override fun onStateChange(node: Node?, newState: Node.State?, prevState: Node.State?) {

        if (newState == Node.State.Connected) {
            if (node != null) {
                stateListener.onStateConnected(node.name)
            } else
                stateListener.onStateDisconnected()
        } else if (newState == Node.State.Unreachable || newState == Node.State.Dead || newState == Node.State.Lost) {
//            val name = if (node!=null) node.name else "no name"
            stateListener.onStateDisconnected()
        }
    }

//    internal var mMagnetometerReading = FloatArray(3) // magnetometer
//    internal var mAccelerometerReading = FloatArray(3) //acc

    private var gyroLastUpdateTime: Long = -1

    private val angles: FloatArray = FloatArray(3)

    override fun onUpdate(f: Feature, sample: Feature.Sample) {
        when (f) {
            is FeatureMagnetometer -> {
                for (i in mMagnetometerReading.indices) {
                    mMagnetometerReading[i] = sample.data[i].toFloat()
                }
                magnetometerListener?.onMagnetometerDataUpdate(mMagnetometerReading)
            }
            is FeatureAcceleration -> {
                for (i in mAccelerometerReading.indices) {
                    mAccelerometerReading[i] = SensorManager.STANDARD_GRAVITY * sample.data[i].toFloat() / 1024
                }
                accelerometerListener?.onAccelerometerDataUpdate(mAccelerometerReading)
            }
            is FeatureGyroscope -> {
                for (i in mGyroReading.indices) {
                    mGyroReading[i] = sample.data[i].toFloat()
                    updateAngle(i, sample)
                }

                gyroLastUpdateTime = sample.timestamp
                gyroListener?.onGyroDataUpdate(angles)
            }
        }
    }

    private fun updateAngle(angleIndex: Int, sample: Feature.Sample) {
        if (gyroLastUpdateTime != -1L) {
            val dt = (sample.timestamp - gyroLastUpdateTime) / 1000f
            Timber.d(dt.toString())
            angles[angleIndex] += (dt * 125 * mGyroReading[angleIndex] / 3276.8).toFloat()
        }
    }


    private var mPrevReadingTimestamp: Long = -1
    private var vx0: Double = 0.0
    private var vy0: Double = 0.0
    private val distance: MutableList<Distance> = mutableListOf()

    private fun calculateDistance(sample: Feature.Sample) {
        val currentTimeMillis = sample.timestamp
        if (mPrevReadingTimestamp == -1L) {
            mPrevReadingTimestamp = sample.timestamp
            return
        }

        val deltaTime = (currentTimeMillis - mPrevReadingTimestamp).toDouble()
        val t = deltaTime / 1000
        val ax = sample.data[0].toDouble() / 1024
        val ay = sample.data[1].toDouble() / 1024

//        get traveled distance
        val sx = vx0 * t + ax * t * t / 2
        val sy = vy0 * t + ay * t * t / 2
        synchronized(distance, {
            distance.add(Distance(sx, sy, t))
        })

//        prepare for next iteration
        vx0 += ax * t
        vy0 += ay * t

        mPrevReadingTimestamp = currentTimeMillis
    }

    data class Distance(val x: Double, val y: Double, val deltaTime: Double) : Comparable<Distance> {
        override fun compareTo(other: Distance): Int {
            return ((this.x + this.y - other.x - other.y) * Math.pow(10.0, 8.0)).toInt()
        }
    }

    private var angle: Double = 0.0
    private var lastTimeSec: Float = 0f

    fun updateAngle() {
        val accDegrees = Math.toDegrees(Math.atan2(mAccelerometerReading[2].toDouble(),
                mAccelerometerReading[1].toDouble()))
        val now = System.currentTimeMillis() / 1000f
        val deltaTime = if (lastTimeSec != 0f) lastTimeSec - now else 0f
        angle = 0.98 * (angle + mGyroReading[0] * deltaTime) + 0.02 * accDegrees
        lastTimeSec = now
    }
}

