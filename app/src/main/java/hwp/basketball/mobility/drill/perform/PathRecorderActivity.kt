package hwp.basketball.mobility.pathrecorder

import android.app.ProgressDialog
import android.app.ProgressDialog.STYLE_HORIZONTAL
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.TextView
import be.rijckaert.tim.animatedvector.FloatingMusicActionButton
import hwp.basketball.mobility.R
import hwp.basketball.mobility.device.sensor.SensorFactory
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingViewPresenter
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingViewViewContract
import hwp.basketball.mobility.util.ViewUtils
import hwp.basketball.mobility.util.bindView
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.activity_path_recorder.*

class PathRecorderActivity : AppCompatActivity(), PathRecorderActivityContract.View {
    companion object {
        private val EXTRA_USER: String = "extra_user"
        internal fun getStartIntent(context: Context, user: String): Intent {
            val intent = Intent(context, PathRecorderActivity::class.java)
            intent.putExtra(EXTRA_USER, user)
            return intent
        }
    }

    private val tvAccMultiplier by bindView<TextView>(R.id.tvAccMultiplier)
    private val tvAngleDiff by bindView<TextView>(R.id.tvAngleDiff)
    private val tvMinSpeed by bindView<TextView>(R.id.tvMinSpeed)
    private val sketchView by bindView<SensorDrawingView>(R.id.sketchView)
    private val sbAccMultiplier by bindView<SeekBar>(R.id.sbAccMultiplier)
    private val sbAngleDiff by bindView<SeekBar>(R.id.sbAngleDiff)
    private val sbMinSpeed by bindView<SeekBar>(R.id.sbMinSpeed)

    private var sensorDrawingViewPresenter: SensorDrawingViewViewContract.Presenter? = null

    private val onSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onStartTrackingTouch(seekBar: SeekBar?) {}
        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        override fun onProgressChanged(seekBar: SeekBar?, prog: Int, fromUser: Boolean) {
            seekBar?.let {
                when (it.id) {
                    R.id.sbAccMultiplier -> {
                        val progress = prog / 5f
                        SensorDrawingView.setMultiplier(progress)
                        tvAccMultiplier.text =
                                String.format(getString(R.string.acceleration_multiplier_value), progress)
                    }
                    R.id.sbAngleDiff -> {
                        val progress = prog / 100.0
                        SensorDrawingView.setAngleDiff(progress)
                        tvAngleDiff.text = String.format(getString(R.string.angle_diff_value), progress)
                    }
                    R.id.sbMinSpeed -> {
                        val progress = prog / 200f
                        SensorDrawingView.setMinSpeed(progress)
                        tvMinSpeed.text = String.format(getString(R.string.min_speed_s), progress)
                    }
                }

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_recorder)

        setupSketchView()
 
        title = "Drill name: " + DrillSetupOutput.drill?.name ?: "Unknown drill"

        fab.setOnClickListener({ onFabClicked() })

        val connectionData = DrillSetupOutput.connectMap[DrillSetupOutput.players[0]]
        connectionData?.let {
            val sensor = SensorFactory.getSensor(connectionData.type, this)
            sensorDrawingViewPresenter = SensorDrawingViewPresenter(sketchView, sensor, this)
            sensorDrawingViewPresenter?.attach()
            sensorDrawingViewPresenter?.prepareConnectedSensor(connectionData.name)
        }
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        tvAccMultiplier.text =
                String.format(getString(R.string.acceleration_multiplier_value), SensorDrawingView.ACC_MULTIPLIER)
        sbAccMultiplier.progress = (SensorDrawingView.ACC_MULTIPLIER * 5).toInt()
        sbAccMultiplier.setOnSeekBarChangeListener(onSeekBarChangeListener)

        tvAngleDiff.text =
                String.format(getString(R.string.angle_diff_value), SensorDrawingView.ANGLE_DIFF_CUTOFF)
        sbAngleDiff.progress = (SensorDrawingView.ANGLE_DIFF_CUTOFF * 100).toInt()
        sbAngleDiff.setOnSeekBarChangeListener(onSeekBarChangeListener)

        tvMinSpeed.text =
                String.format(getString(R.string.min_speed_s), SensorDrawingView.MIN_SPEED)
        sbMinSpeed.progress = (SensorDrawingView.MIN_SPEED * 200).toInt()
        sbMinSpeed.setOnSeekBarChangeListener(onSeekBarChangeListener)

        refreshDebugViews()

    }

    private fun onFabClicked() {
        sensorDrawingViewPresenter?.onPlayPauseDrillClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        sensorDrawingViewPresenter?.detach()
    }

    private fun setupSketchView() {
        val (height, width) = ViewUtils.getDeviceSize()
        val aspectRatio = height.toFloat() / width.toFloat()

        sketchView.setAspectRatio(aspectRatio)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_devices, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_showStats -> {
                ViewUtils.isInDebugMode = !ViewUtils.isInDebugMode
                refreshDebugViews()
            }
            R.id.menu_reset_drill -> sensorDrawingViewPresenter?.restartDrill()
            else -> return super.onOptionsItemSelected(item)
        }
        invalidateOptionsMenu()
        return true
    }

    private fun refreshDebugViews() {
        if (ViewUtils.isInDebugMode) {
            ll_sb_container.visibility = View.VISIBLE
            tv_stats.visibility = View.VISIBLE
        } else {
            ll_sb_container.visibility = View.GONE
            tv_stats.visibility = View.GONE
        }
    }

    override fun onDrillFinished() {
//        invalidateOptionsMenu()
//        fab.changeMode(FloatingMusicActionButton.Mode.PLAY_TO_PAUSE)
//        fab.playAnimation()
    }

    override fun displayStats(statistics: String) {
        tv_stats.text = statistics
    }

    override fun displayOutcome(outcome: DrillOutcome) {
        AlertDialog.Builder(this)
                .setTitle("Good job!")
                .setMessage("Drill completed with score ${outcome.score}!" +
                        "\nDo you want to save output to DB?")
                .setPositiveButton("Yes") { _, _ ->
                    sensorDrawingViewPresenter?.onSaveDrillOutcome(outcome)
                }
                .setNegativeButton("No", { dlgInterface, _ ->
                    dlgInterface.dismiss()
                })
                .show()

    }

    override fun hideProgress() {
        progressDialog?.dismiss()
    }

    override fun showError(message: String) {
        toast(message)
    }

    private var progressDialog: ProgressDialog? = null

    override fun showScoreProgress(message: String) {
        hideProgress()

        progressDialog = ProgressDialog(this)
        progressDialog?.let { progress ->
            progress.max = 100
            progress.setTitle("Calculating area")
            progress.setMessage("Calculating area for performed drill!")
            progress.setProgressStyle(STYLE_HORIZONTAL)
            progress.isIndeterminate = false
            progress.progress = 0
            progress.show()
        }
    }

    override fun showProgress(message: String) {
        hideProgress()
        progressDialog = ProgressDialog.show(this, "Loading", message, false)
    }

    override fun updateScoreProgress(progress: Int) {
        progressDialog?.progress = progress
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun onRecordingModeChange(isInRecordingMode: Boolean) {
        if (!isInRecordingMode) {
            fab.changeMode(FloatingMusicActionButton.Mode.PAUSE_TO_PLAY)
        } else {
            fab.changeMode(FloatingMusicActionButton.Mode.PLAY_TO_PAUSE)
        }
//        runOnUiThread({
            fab.playAnimation()
//        })

    }
}