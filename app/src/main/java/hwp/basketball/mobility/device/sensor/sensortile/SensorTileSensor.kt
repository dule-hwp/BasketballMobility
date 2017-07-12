package hwp.basketball.mobility.device.sensor.sensortile

import android.content.Context
import com.st.BlueSTSDK.Feature
import com.st.BlueSTSDK.Features.*
import com.st.BlueSTSDK.Manager
import com.st.BlueSTSDK.Node
import hwp.basketball.mobility.device.sensor.BMSensorManager.AccData
import hwp.basketball.mobility.device.sensor.BaseSensor
import timber.log.Timber

/**
 *
 * Created by dusan_cvetkovic on 3/4/17.
 */

open class SensorTileSensor(val context: Context)
    : BaseSensor(), Feature.FeatureListener, Node.NodeStateListener {

    private var node: Node? = null

    override fun subscribeForUpdates() {
        subscribeToAccChange()
        subscribeToMagnetometerChange()
        subscribeToGyroChange()
        subscribeToMotionChange()
        subscribeToAngleChangeChange()
        subscribeToSpeedChange()
    }

    fun subscribeToAngleChangeChange() {
        val featureMagnetometer = node?.getFeature(FeatureCompass::class.java)
        featureMagnetometer?.addFeatureListener(this)
        node?.enableNotification(featureMagnetometer)
    }

    fun subscribeToSpeedChange() {
        val featurePedometer = node?.getFeature(FeaturePedometer::class.java)
        featurePedometer?.addFeatureListener(this)
        node?.enableNotification(featurePedometer)
    }

    override fun disconnect() {
        node?.features?.forEach { feature ->
            feature?.removeFeatureListener(this)
            node?.disableNotification(feature)
        }
        node?.disconnect()
    }

    fun subscribeToMagnetometerChange() {
        val featureMagnetometer = node?.getFeature(FeatureMagnetometer::class.java)
        featureMagnetometer?.addFeatureListener(this)
        node?.enableNotification(featureMagnetometer)
    }

    fun subscribeToAccChange() {
        val featureAcceleration = node?.getFeature(FeatureAcceleration::class.java)
        featureAcceleration?.addFeatureListener(this)
        node?.enableNotification(featureAcceleration)
    }

    fun subscribeToGyroChange() {
        val featureGyroscope = node?.getFeature(FeatureGyroscope::class.java)
        featureGyroscope?.addFeatureListener(this)
        node?.enableNotification(featureGyroscope)
    }

    fun subscribeToMotionChange() {
        val featureMotion = node?.getFeature(FeatureMotionIntensity::class.java)
        featureMotion?.addFeatureListener(this)
        node?.enableNotification(featureMotion)
    }

    override fun getName(): String {
        return SensorTileSensor::class.java.simpleName
    }

    override fun connectTo(deviceID: String) {
        node = Manager.getSharedInstance().getNodeWithTag(deviceID)
        node?.let {
            if (!it.isConnected) {
                it.addNodeStateListener(this)
                it.connect(context)
            }
        }
    }

    override val isConnectable: Boolean = true

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

    private lateinit var stepData: StepData

    override fun onUpdate(f: Feature, sample: Feature.Sample) {
        when (f) {
            is FeatureMagnetometer -> {
                for (i in mMagnetometerReading.indices) {
                    mMagnetometerReading[i] = sample.data[i].toFloat()
                }
//                magnetometerListener?.onMagnetometerDataUpdate(mMagnetometerReading)
            }
            is FeatureAcceleration -> {
                for (i in mAccelerometerReading.indices) {
                    mAccelerometerReading[i] = sample.data[i].toFloat()
                }
                accelerometerObservable.onNext(AccData(mAccelerometerReading, sample.timestamp))
            }
            is FeatureGyroscope -> {
                for (i in mGyroReading.indices) {
                    mGyroReading[i] = sample.data[i].toFloat()
                }

                gyroLastUpdateTime = sample.timestamp
//                gyroListener?.onGyroDataUpdate(angles)
            }
            is FeaturePedometer -> {
                stepData = StepData(FeaturePedometer.getSteps(sample).toInt(),
                        FeaturePedometer.getFrequency(sample))
                Timber.d("$stepData")
                motionObservable.onNext(false)
                motionObservable.onNext(true)
            }
            is FeatureCompass -> {
//                angleListener?.onAngleDataUpdate(sample.data[0].toFloat())
                angleObservable.onNext(sample.data[0].toFloat())
            }
            is FeatureMotionIntensity -> {
                val intensity = FeatureMotionIntensity.getMotionIntensity(sample)
                motionObservable.onNext(intensity > 5)
            }
        }
    }

    /**
     * Type Used to save step data.
     * @param stepCount number of steps since device restart
     * @param frequency current "speed" in steps/min (not very accurate)
     * */
    data class StepData(val stepCount: Int, val frequency: Int)
}

