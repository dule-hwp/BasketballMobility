package hwp.basketball.mobility.drill.create

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.jakewharton.rxbinding2.widget.RxTextView
import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.drills.ViewDimens
import hwp.basketball.mobility.util.CanvasView
import hwp.basketball.mobility.util.toast
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.activity_drill.*
import timber.log.Timber

class DrillActivity : AppCompatActivity(), DrillActivityContract.View, DialogInterface.OnClickListener {

    private lateinit var drillActivityPresenter: DrillActivityContract.Presenter


    private var progress: ProgressDialog? = null

    override fun hideProgressDialog() {
        progress?.dismiss()
    }

    override fun showProgressDialog(message: String) {
        progress?.dismiss()
        progress = ProgressDialog.show(this, "Loading..." ,message, true)
    }

    override fun displayError(message: String) {
        toast(message)
    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        if (which == AlertDialog.BUTTON_POSITIVE) {
            drillActivityPresenter.onDrillDataFilled(canvas_view.pathPoints.toList(), drillName,
                    numOfPlayers, canvas_view.getBitmap(), ViewDimens(canvas_view.width, canvas_view.height))
        }
        dialog?.dismiss()
        disposeDlgListeners()
    }

    private var disposable: Disposable? = null

    override fun promptForDrillNameDialog(draw: Bitmap?) {
        val view = LayoutInflater.from(this).inflate(R.layout.dlg_save_drill, null)
        val etDrillName: TextInputEditText = view.findViewById(R.id.et_drill_name) as TextInputEditText
        val etDrillNumOfPlayers: TextInputEditText = view.findViewById(R.id.et_num_of_players) as TextInputEditText
        val imageView: ImageView = view.findViewById(R.id.imageView) as ImageView
        imageView.setImageBitmap(canvas_view.getBitmap())

        val alertDialog = AlertDialog.Builder(this)
                .setPositiveButton("OK", this)
                .setNegativeButton("Cancel", this)
                .setView(view)
                .setOnCancelListener { disposeDlgListeners() }
                .setOnDismissListener {
                    Timber.d("dismissed dlg")
                    disposeDlgListeners()
//                    finish()
                }
                .create()
        alertDialog.show()

        val btnOk = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE)
        btnOk.isEnabled = false

        val observableName = RxTextView.textChanges(etDrillName).map(CharSequence::toString)
        val observablePlayers = RxTextView.textChanges(etDrillNumOfPlayers).map(CharSequence::toString)

        disposable = Observable.combineLatest(observableName, observablePlayers, observableName,
                Function3 { name: String, charSeqNumOfPlayers: String, _: CharSequence ->
                    drillName = name
                    if (!charSeqNumOfPlayers.isEmpty())
                        numOfPlayers = Integer.parseInt(charSeqNumOfPlayers)
                    name.isEmpty() || charSeqNumOfPlayers.isEmpty()
                })
                .skip(1)
                .subscribe { isOneEmpty: Boolean ->
                    btnOk.isEnabled = !isOneEmpty
                }
    }

    private fun disposeDlgListeners() {
        disposable?.let {
            if (!it.isDisposed)
                it.dispose()
        }
    }

    override fun takeADrillScreenshot() {
        promptForDrillNameDialog(null)
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, DrillActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill)

        drillActivityPresenter = DrillActivityPresenter(this)

        btn_done.setOnClickListener { drillActivityPresenter.onDoneTap() }
        canvas_view.drawer = CanvasView.Drawer.LINE
        canvas_view.currentPath
    }

    private var drillName: String = ""
    private var numOfPlayers: Int = 1

    override fun finishActivity() {
        val data = Intent()
        setResult(Activity.RESULT_OK, data)
        Timber.d("done setting result!!!")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        drillActivityPresenter.detach()
    }

    fun onUndoClicked(view: View) {
        canvas_view.undo()
    }

    fun onRedoClicked(view: View) {
        canvas_view.redo()
    }

    fun onClearClicked(view: View) {
        canvas_view.clear()
    }


}


