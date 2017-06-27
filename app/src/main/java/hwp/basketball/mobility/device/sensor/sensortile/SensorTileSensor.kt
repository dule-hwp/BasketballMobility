package hwp.basketball.mobility.device.sensor.sensortile

import android.content.Context
import android.os.Environment
import com.google.common.io.Files
import com.google.gson.Gson
import com.st.BlueSTSDK.Feature
import com.st.BlueSTSDK.Features.*
import com.st.BlueSTSDK.Manager
import com.st.BlueSTSDK.Node
import hwp.basketball.mobility.TestData
import hwp.basketball.mobility.device.sensor.BaseSensor
import timber.log.Timber
import java.io.File
import java.io.IOException
import java.util.*

/**
 *
 * Created by dusan_cvetkovic on 3/4/17.
 */

open class SensorTileSensor(context: Context)
    : BaseSensor(context), Feature.FeatureListener, Node.NodeStateListener {
    override fun subscribeToAngleChangeChange() {
        val featureMagnetometer = node?.getFeature(FeatureCompass::class.java)
        featureMagnetometer?.addFeatureListener(this)
        node?.enableNotification(featureMagnetometer)
    }

    override fun subscribeToSpeedChange() {
        val featurePedometer = node?.getFeature(FeaturePedometer::class.java)
        featurePedometer?.addFeatureListener(this)
        node?.enableNotification(featurePedometer)
    }

    override fun unSubscribe() {
        node?.features?.stream()?.forEach { feature ->
            feature?.removeFeatureListener(this)
            node?.disableNotification(feature)
        }
        node?.disconnect()
    }

    override fun subscribeToMagnetometerChange() {
        val featureMagnetometer = node?.getFeature(FeatureMagnetometer::class.java)
        featureMagnetometer?.addFeatureListener(this)
        node?.enableNotification(featureMagnetometer)
    }

    override fun subscribeToAccChange() {
        val featureAcceleration = node?.getFeature(FeatureAcceleration::class.java)
        featureAcceleration?.addFeatureListener(this)
        node?.enableNotification(featureAcceleration)
    }

    override fun subscribeToGyroChange() {
        val featureGyroscope = node?.getFeature(FeatureGyroscope::class.java)
        featureGyroscope?.addFeatureListener(this)
        node?.enableNotification(featureGyroscope)
    }

    override fun subscribeToMotionChange() {
        val featureMotion = node?.getFeature(FeatureMotionIntensity::class.java)
        featureMotion?.addFeatureListener(this)
        node?.enableNotification(featureMotion)
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
                stateListener?.onStateConnected(node.name)
            } else
                stateListener?.onStateDisconnected()
        } else if (newState == Node.State.Unreachable || newState == Node.State.Dead || newState == Node.State.Lost) {
//            val name = if (node!=null) node.name else "no name"
            stateListener?.onStateDisconnected()
        }
    }

    private var gyroLastUpdateTime: Long = -1

    private val angles: FloatArray = FloatArray(3)

    private val mTestData: MutableList<TestData> = mutableListOf()

    override fun onUpdate(f: Feature, sample: Feature.Sample) {
//        mTestData.addDrillToDatabase(TestData(f.name, sample))
        when (f) {
            is FeatureMagnetometer -> {
                for (i in mMagnetometerReading.indices) {
                    mMagnetometerReading[i] = sample.data[i].toFloat()
                }
                magnetometerListener?.onMagnetometerDataUpdate(mMagnetometerReading)
            }
            is FeatureAcceleration -> {
                for (i in mAccelerometerReading.indices) {
//                    mAccelerometerReading[i] = SensorManager.STANDARD_GRAVITY * sample.data[i].toFloat() / 1000
                    mAccelerometerReading[i] = sample.data[i].toFloat()
                }
                accelerometerListener?.onAccelerometerDataUpdate(mAccelerometerReading, sample.timestamp)
            }
            is FeatureGyroscope -> {
                for (i in mGyroReading.indices) {
                    mGyroReading[i] = sample.data[i].toFloat()
                    updateAngle(i, sample)
                }

                gyroLastUpdateTime = sample.timestamp
                gyroListener?.onGyroDataUpdate(angles)
            }
            is FeaturePedometer -> {
                val stepData = StepData(FeaturePedometer.getSteps(sample).toInt(),
                        FeaturePedometer.getFrequency(sample))
                stepListener?.onStepDataUpdate(stepData)
            }
            is FeatureCompass -> {
                angleListener?.onAngleDataUpdate(sample.data[0].toFloat())
            }
            is FeatureMotionIntensity -> {
                val intensity = FeatureMotionIntensity.getMotionIntensity(sample)
                motionListener?.onMotionDataUpdate(intensity.toInt())
            }
        }
    }

    override fun saveSensorData(suffix: String): String {
        val time = Date().time
        val file = File(Environment.getExternalStorageDirectory(), "test_$suffix" + "_$time")
        val json = Gson().toJson(ArrayList(mTestData))
        var res = "default"
        try {
            Files.write(json, file, Charsets.UTF_8)
            res = "file written."
            mTestData.clear()
            Timber.d(res)
        } catch (e: IOException) {
            Timber.e(e.message)
            res = e.message ?: "Exception unknown"
        }
        return res

    }


    private fun updateAngle(angleIndex: Int, sample: Feature.Sample) {
        if (gyroLastUpdateTime != -1L) {
            //covert delta time to seconds
            val dt = (sample.timestamp - gyroLastUpdateTime) / 1000f
            angles[angleIndex] += dt * mGyroReading[angleIndex]
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
        val t = deltaTime / 100
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
}

