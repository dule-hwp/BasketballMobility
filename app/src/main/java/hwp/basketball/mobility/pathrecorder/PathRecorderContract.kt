package hwp.basketball.mobility.pathrecorder

import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor

/**
 * Created by dusan_cvetkovic on 3/5/17.
 */

interface PathRecorderContract {
    interface View {
//        fun updateOrientation(angle: Float)
        fun startScanActivity()
//        fun scheduleUIUpdates()
        fun onSensorDisconnected()
        fun onSensorConnected(sensorManager: BMSensorManager)
//        fun addMagnetometerListener(sensor: BaseSensor)
    }

    interface Presenter: BasePresenter {
        fun connectToTag(nodeTag: String)
//        fun updateOrientationValue()
//        fun setSelectedRotation(selectedRotation: Int)
//        fun subscribeToMagnetometerEvents(magnetometerListener: BaseSensor.MagnetometerDataChangedCallback)
    }
}
