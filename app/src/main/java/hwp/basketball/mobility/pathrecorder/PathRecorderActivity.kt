package hwp.basketball.mobility.pathrecorder

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import hugo.weaving.DebugLog
import hwp.basketball.mobility.R
import hwp.basketball.mobility.dagger.ContextModule
import hwp.basketball.mobility.dagger.DaggerBasketballMobilityAppComponent
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.pathrecorder.sketchview.SketchViewPresenter
import hwp.basketball.mobility.sensortilescan.ScanActivity
import kotlinx.android.synthetic.main.activity_path_recorder.*

class PathRecorderActivity : AppCompatActivity(), PathRecorderContract.View {
    companion object {
        private val TAG: String = "PathRecorderActivity"
        private val EXTRA_USER: String = "extra_user"
        internal fun getStartIntent(context: Context, user: String): Intent {
            val intent = Intent(context, PathRecorderActivity::class.java)
            intent.putExtra(EXTRA_USER, user)
            return intent
        }
    }

    private var sketchViewPresenter: SketchViewPresenter? = null
    private val pathRecorderPresenter: PathRecorderPresenter = PathRecorderPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_path_recorder)

        val mobilityAppComponent = DaggerBasketballMobilityAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()

        setupSketchView()
        sketchViewPresenter = SketchViewPresenter(sketchView)
        sketchViewPresenter?.attach()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        val bmSensorManager = BMSensorManager(pathRecorderPresenter)
        pathRecorderPresenter.addSensorManager(bmSensorManager)
        pathRecorderPresenter.attach()

        mobilityAppComponent.inject(bmSensorManager)
        prepareConnectedSensors(bmSensorManager)

        btnAxisX.setOnClickListener { sketchViewPresenter?.useRotationAxis(0) }
        btnAxisY.setOnClickListener { sketchViewPresenter?.useRotationAxis(1) }
        btnAxisZ.setOnClickListener { sketchViewPresenter?.useRotationAxis(2) }
    }

    private fun prepareConnectedSensors(bmSensorManager: BMSensorManager) {
        val connectionData = DrillSetupOutput.connectMap[DrillSetupOutput.players[0]]
        connectionData?.let {
            bmSensorManager.setupSensor(connectionData.type)
            when (connectionData.type) {
                BaseSensor.Type.SENSOR_TILE -> {
                    pathRecorderPresenter.connectToTag(connectionData.name)
                }
                BaseSensor.Type.ANDROID_DEVICE -> {
                    onSensorConnected(bmSensorManager)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        sketchViewPresenter?.detach()
        pathRecorderPresenter.detach()
    }


    fun getBitmapResource(index: Int): Bitmap? {
        return BitmapFactory.decodeResource(this.resources, index)
    }

    private fun setupSketchView() {

        // setting view fields
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        var displaySize = Point()

        sketchView.setBeginDrawing(true)

        // get display size for aspect ratio
        try {
            display.getRealSize(displaySize)
        } catch (ex: java.lang.NoSuchMethodError) { // Older device
            displaySize.x = display.width
            displaySize.y = display.height

            // account for orientation change
            val min = Math.min(displaySize.x, displaySize.y)
            val max = Math.max(displaySize.x, displaySize.y)
            displaySize = Point(min, max)
            displaySize.y += (displaySize.x * 0.16).toInt() // fix for status bar height in older API
        }

        val aspectRatio = displaySize.y.toFloat() / displaySize.x.toFloat()

        sketchView.setAspectRatio(aspectRatio)
        sketchView.setBitmapArrow(getBitmapResource(R.drawable.arrow))
    }

    override fun startScanActivity() {
        val connect = Intent(this, ScanActivity::class.java)
        startActivityForResult(connect, ScanActivity.REQUEST_SCAN)
    }

    @DebugLog
    override fun onSensorDisconnected() {
        runOnUiThread {
            Toast.makeText(this, "Disconnected!!!", Toast.LENGTH_LONG).show()
        }
    }

    @DebugLog
    override fun onSensorConnected(sensorManager: BMSensorManager) {
        runOnUiThread {
            Toast.makeText(this, "connected to: " + sensorManager, Toast.LENGTH_LONG).show()
        }
//        addMagnetometerListener(sensorManager)
        sketchViewPresenter?.enableRequiredSensorsUpdate(sensorManager)
    }

    @DebugLog
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_devices, menu)

        sketchViewPresenter?.isInRecordingMode()?.let { isInRecordingMode ->
            menu.findItem(R.id.menu_startResumeMovement).isVisible = !isInRecordingMode
            menu.findItem(R.id.menu_stopMovement).isVisible = isInRecordingMode
        }


        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_showStats -> sketchViewPresenter?.showStats()
            R.id.menu_startResumeMovement -> sketchViewPresenter?.startResumeMovement()
            R.id.menu_stopMovement -> sketchViewPresenter?.stopMovement()
            else -> return super.onOptionsItemSelected(item)
        }
        invalidateOptionsMenu()
        return true
    }

    fun onZoomIn(v: View) {
        sketchViewPresenter?.onZoomIn()
    }

    fun onZoomOut(v: View) {
        sketchViewPresenter?.onZoomOut()
    }

}
