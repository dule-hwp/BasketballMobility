package hwp.basketball.mobility.device.sensor.sensortile.sensortilescan

import android.app.Activity
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.device.sensor.SensorFactory

/**
 * Created by dusan_cvetkovic on 4/11/17.
 */
class SensorsDialog(activity: Activity, private val listener: SensorChooserCallback, firstName: String)
    : DialogInterface.OnClickListener {

    private var alertDialog: AlertDialog?

    init {
        val sensors = SensorFactory.Type
                .values()
                .map { it.name}
                .filter { it != "MOCKED_SENSOR" }
                .toTypedArray()

        val builder = AlertDialog.Builder(activity)
                .setItems(sensors, this)
                .setTitle("Select sensor attached to $firstName.")
                .setOnCancelListener { listener.onNothingSelected() }

        alertDialog = builder.create()
    }

    fun show() {
        alertDialog?.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        listener.onSensorTypeSelected(SensorFactory.Type.values()[which+1])
    }

    interface SensorChooserCallback {
        fun onNothingSelected()
        fun onSensorTypeSelected(sensorType: SensorFactory.Type)
    }
}