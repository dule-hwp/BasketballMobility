package hwp.basketball.mobility.pathrecorder.sketchview

import hugo.weaving.DebugLog
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor

/**
 * Created by dusan_cvetkovic on 3/7/17.
 */
interface SketchViewContract {
    interface View {
        fun setMessages(message1: String, message2: String)
        fun setMessagesWithTimeout(message1: String, message2: String)
        fun setDegreesToNorth(degreesToNorth: Int)
        fun invalidateView()
        fun setPresenter(sketchViewPresenter: SketchViewContract.Presenter)
    }

    interface Presenter : BasePresenter{
        fun getMovementDataForDraw(startPoint: FloatArray): Movement.MovementData?
        fun onZoomIn()
        fun onZoomOut()
        fun showStats()
        fun exportPath()
        fun startResumeMovement()
        fun stopMovement()
        fun followDeviceRotation()
        fun removeAngleChangeListener()
        fun enableRequiredSensorsUpdate(bmSensorManager: BMSensorManager)
        fun disableSensorsUpdate()
        fun isInRecordingMode(): Boolean
        fun useRotationAxis(axisIndex: Int)
    }

    interface MovementCallback {
        fun setDegreesToNorth(degreesToNorth: Int)
    }
}