package hwp.basketball.mobility.drill.create

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Path
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.ImageView
import com.jakewharton.rxbinding2.widget.RxTextView
import com.rm.freedrawview.FreeDrawView
import hwp.basketball.mobility.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.activity_drill.*
import timber.log.Timber
import java.util.ArrayList

class DrillActivity : AppCompatActivity(), DrillActivityContract.View, DialogInterface.OnClickListener {
    override fun onClick(dialog: DialogInterface?, which: Int) {
        if (which == AlertDialog.BUTTON_POSITIVE) {
            drillActivityPresenter.onDrillDataFilled(numOfPlayers, drillName)
        }

    }

    private var disposable: Disposable? = null

    override fun promptForDrillNameDialog(draw: Bitmap?) {
        val view = LayoutInflater.from(this).inflate(R.layout.dlg_save_drill, null)
        val etDrillName: TextInputEditText = view.findViewById(R.id.et_drill_name) as TextInputEditText
        val etDrillNumOfPlayers: TextInputEditText = view.findViewById(R.id.et_num_of_players) as TextInputEditText
        val imageView: ImageView = view.findViewById(R.id.imageView) as ImageView
        imageView.setImageBitmap(draw)

        val alertDialog = AlertDialog.Builder(this)
                .setPositiveButton("OK") { dialog, _ ->
                    drillActivityPresenter.onDrillDataFilled(numOfPlayers, drillName)
                    dialog?.dismiss()
                    disposeDlgListeners()
                }
                .setNegativeButton("Cancel", this)
                .setView(view)
                .setOnCancelListener { disposeDlgListeners() }
                .setOnDismissListener {
                    Timber.d("dismissed dlg")
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
        free_draw_view.getDrawScreenshot(drillActivityPresenter)
    }

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, DrillActivity::class.java)
        }

        val EXTRA_PATH = "points"
        val EXTRA_IMAGE = "image"
        val EXTRA_NAME = "name"
    }

    private lateinit var drillActivityPresenter: DrillActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill)

        drillActivityPresenter = DrillActivityPresenter(this)

        free_draw_view.setOnPathDrawnListener(drillActivityPresenter)
        free_draw_view.setPathRedoUndoCountChangeListener(drillActivityPresenter)
        btn_done.setOnClickListener { drillActivityPresenter.onDoneTap() }
        free_draw_view.getPaths()
    }

    private var drillName: String? = ""
    private var numOfPlayers: Int = 1

    override fun finishActivity() {
        val data = Intent()

//        drawImage?.let { data.putExtra(EXTRA_IMAGE, drawImage) }
//        mCurrentPathPoints?.let { data.putExtra(EXTRA_PATH, mCurrentPathPoints) }
//        mCurrentPathPoints?.let { data.putExtra(EXTRA_NAME, drillName) }

        setResult(Activity.RESULT_OK, data)
        Timber.d("done setting result!!!")
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun FreeDrawView.getPaths() {
        val declaredField = this::class.java.getDeclaredField("mPaths")
        declaredField.isAccessible = true
        val paths = declaredField.get(this) as ArrayList<*>

    }
}


