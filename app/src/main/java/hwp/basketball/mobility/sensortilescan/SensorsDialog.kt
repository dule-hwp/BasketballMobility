package hwp.basketball.mobility.sensortilescan

import android.app.Activity
import android.content.DialogInterface
import android.support.v7.app.AlertDialog

/**
 * Created by dusan_cvetkovic on 4/11/17.
 */
class SensorsDialog(private val activity: Activity, private val listener: SensorChooserCallback, firstName: String)
    : DialogInterface.OnClickListener{

    private var alertDialog: AlertDialog?

    init{
        val builder = AlertDialog.Builder(activity)
                .setItems(arrayOf("SensorTile", "Android"), this)
                .setTitle("Select sensor attached to $firstName.")
                .setOnCancelListener { listener.onNothingSelected() }

        alertDialog = builder.create()
    }

    fun show(){
        alertDialog?.show()
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        when (which){
            0 -> listener.onSensorTileSelected()
            1 -> listener.onAndroidSensorSelected()
            else -> listener.onNothingSelected()
        }
    }

    interface SensorChooserCallback{
        fun onSensorTileSelected()
        fun onAndroidSensorSelected()
        fun onNothingSelected()
    }
}