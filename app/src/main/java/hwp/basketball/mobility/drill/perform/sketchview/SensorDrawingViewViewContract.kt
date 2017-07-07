package hwp.basketball.mobility.pathrecorder.sketchview

import android.graphics.Bitmap
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.IBMSensorManager
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome

/**
 *
 * Created by dusan_cvetkovic on 3/7/17.
 */
interface SensorDrawingViewViewContract {
    interface View {
        fun setDegreesToNorth(degreesToTrueNorth: Float)
        fun invalidateView()
        fun setPresenter(sensorDrawingViewPresenter: SensorDrawingViewViewContract.Presenter)
        fun onSensorConnected(bmSensorManager: IBMSensorManager)
        fun onSensorDisconnected(bmSensorManager: IBMSensorManager)
        fun addAccData(accData: BMSensorManager.AccData)
        fun invalidate()
        fun showToastMessage(message: String)
        fun setIsMoving(isMoving: Boolean)
        fun resetDrill()
        fun getBitmap(): Bitmap
        fun getDesiredPathLength() :Float
        fun getBitmapArea(): Bitmap
        fun onRecordingModeChange(inRecordingMode: Boolean)
    }

    interface Presenter : BasePresenter{
        fun startResumeMovement()
        fun stopMovement()
        fun disableSensorsUpdate()
        fun prepareConnectedSensor(name: String)
        fun onDrillCompleted()
        fun displayStats(statistics: ArrayList<String>)
        fun restartDrill()
        fun onSaveDrillOutcome(outcome: DrillOutcome)
        fun onPlayPauseDrillClick()
    }
}