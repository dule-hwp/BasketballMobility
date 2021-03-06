[app](../../index.md) / [hwp.basketball.mobility.pathrecorder.sketchview](../index.md) / [SensorDrawingView](.)

# SensorDrawingView

`class SensorDrawingView : `[`View`](https://developer.android.com/reference/android/view/View.html)`, `[`View`](../-sensor-drawing-view-view-contract/-view/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SensorDrawingView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>`SensorDrawingView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`?)`<br>`SensorDrawingView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`?, defStyleAttr: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Properties

| Name | Summary |
|---|---|
| [a](a.md) | `var a: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Current magnitude of linear acceleration in m/s. |
| [accBasedMoves](acc-based-moves.md) | `val accBasedMoves: `[`ConcurrentLinkedQueue`](https://developer.android.com/reference/java/util/concurrent/ConcurrentLinkedQueue.html)`<`[`Move`](../-movement/-move/index.md)`>`<br>List of moves generated by |
| [actualEndPoint](actual-end-point.md) | `var actualEndPoint: `[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md) |
| [compassView](compass-view.md) | `val compassView: `[`CompassView`](../../hwp.basketball.mobility.view/-compass-view/index.md) |
| [courtBackGround](court-back-ground.md) | `lateinit var courtBackGround: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html) |
| [currentDistanceFromDesiredPath](current-distance-from-desired-path.md) | `var currentDistanceFromDesiredPath: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Distance of the current location from the desired path. Used for detecting when user is off the path |
| [currentSegmentAngle](current-segment-angle.md) | `var currentSegmentAngle: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [currentSegmentIndex](current-segment-index.md) | `var currentSegmentIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [desiredPath](desired-path.md) | `val desiredPath: `[`Path`](https://developer.android.com/reference/android/graphics/Path.html)<br>Path generated using drill creation interface. Generated by coach and passed as a parameter to this view. |
| [distanceCovered](distance-covered.md) | `var distanceCovered: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>Distance covered by player (in pixels). |
| [isMoving](is-moving.md) | `var isMoving: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isOffThePath](is-off-the-path.md) | `var isOffThePath: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [listDebugMessages](list-debug-messages.md) | `val listDebugMessages: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>`<br>List to be used for informing UI about debug data. |
| [mPresenter](m-presenter.md) | `lateinit var mPresenter: `[`Presenter`](../-sensor-drawing-view-view-contract/-presenter/index.md) |
| [mPrevReadingTimestamp](m-prev-reading-timestamp.md) | `var mPrevReadingTimestamp: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Previously read timestamp |
| [movingAverageLinearAcc](moving-average-linear-acc.md) | `val movingAverageLinearAcc: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`MovingAverage`](../../hwp.basketball.mobility.util/-moving-average/index.md)`>`<br>Array (for each axis value) of moving average windows |
| [offDesiredPath](off-desired-path.md) | `var offDesiredPath: `[`Path`](https://developer.android.com/reference/android/graphics/Path.html) |
| [paintArea](paint-area.md) | `var paintArea: `[`Paint`](https://developer.android.com/reference/android/graphics/Paint.html) |
| [paintCurrentLocation](paint-current-location.md) | `var paintCurrentLocation: `[`Paint`](https://developer.android.com/reference/android/graphics/Paint.html) |
| [paintDesiredPath](paint-desired-path.md) | `var paintDesiredPath: `[`Paint`](https://developer.android.com/reference/android/graphics/Paint.html) |
| [paintSensorPath](paint-sensor-path.md) | `var paintSensorPath: `[`Paint`](https://developer.android.com/reference/android/graphics/Paint.html) |
| [pathLength](path-length.md) | `val pathLength: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [pathMeasure](path-measure.md) | `val pathMeasure: `[`PathMeasure`](https://developer.android.com/reference/android/graphics/PathMeasure.html)<br>Variable for measuring how far user got on the desired path. |
| [pathSegmentsLengths](path-segments-lengths.md) | `val pathSegmentsLengths: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>>` |
| [pathViewPoints](path-view-points.md) | `val pathViewPoints: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md)`>` |
| [sensorPath](sensor-path.md) | `var sensorPath: `[`Path`](https://developer.android.com/reference/android/graphics/Path.html)<br>Path generated by using values from sensor. |
| [startPoint](start-point.md) | `var startPoint: `[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md) |
| [v0](v0.md) | `var v0: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)<br>Current speed. Should be im m/s but not quite true. |
| [viewDimens](view-dimens.md) | `val viewDimens: `[`ViewDimens`](../../hwp.basketball.mobility.entitiy.drills/-view-dimens/index.md) |

### Functions

| Name | Summary |
|---|---|
| [InitSketch](-init-sketch.md) | `fun InitSketch(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [addAccData](add-acc-data.md) | `fun addAccData(accData: `[`AccData`](../../hwp.basketball.mobility.device.sensor/-b-m-sensor-manager/-acc-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [calculateLinearAccAndGravity](calculate-linear-acc-and-gravity.md) | `fun calculateLinearAccAndGravity(sample: `[`AccData`](../../hwp.basketball.mobility.device.sensor/-b-m-sensor-manager/-acc-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drawBackground](draw-background.md) | `fun drawBackground(canvas: `[`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAngleLengthForSegmentIndex](get-angle-length-for-segment-index.md) | `fun getAngleLengthForSegmentIndex(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, previousLength: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>` |
| [getBitmap](get-bitmap.md) | `fun getBitmap(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html) |
| [getBitmapArea](get-bitmap-area.md) | `fun getBitmapArea(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html) |
| [getDesiredPathLength](get-desired-path-length.md) | `fun getDesiredPathLength(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getStatistics](get-statistics.md) | `fun getStatistics(): `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |
| [initBeforeDrillStart](init-before-drill-start.md) | `fun initBeforeDrillStart(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invalidateView](invalidate-view.md) | `fun invalidateView(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDraw](on-draw.md) | `fun onDraw(canvas: `[`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRecordingModeChange](on-recording-mode-change.md) | `fun onRecordingModeChange(inRecordingMode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorConnected](on-sensor-connected.md) | `fun onSensorConnected(bmSensorManager: `[`IBMSensorManager`](../../hwp.basketball.mobility.device.sensor/-i-b-m-sensor-manager/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorDisconnected](on-sensor-disconnected.md) | `fun onSensorDisconnected(bmSensorManager: `[`IBMSensorManager`](../../hwp.basketball.mobility.device.sensor/-i-b-m-sensor-manager/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [resetDrill](reset-drill.md) | `fun resetDrill(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setAspectRatio](set-aspect-ratio.md) | `fun setAspectRatio(aspectRatio: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDegreesToNorth](set-degrees-to-north.md) | `fun setDegreesToNorth(degreesToTrueNorth: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setIsMoving](set-is-moving.md) | `fun setIsMoving(isMoving: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setPresenter](set-presenter.md) | `fun setPresenter(sensorDrawingViewPresenter: `[`Presenter`](../-sensor-drawing-view-view-contract/-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showToastMessage](show-toast-message.md) | `fun showToastMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateCurrentSegmentValues](update-current-segment-values.md) | `fun updateCurrentSegmentValues(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateSensorPath](update-sensor-path.md) | `fun updateSensorPath(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [ACC_MULTIPLIER](-a-c-c_-m-u-l-t-i-p-l-i-e-r.md) | `var ACC_MULTIPLIER: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [ANGLE_DIFF_CUTOFF](-a-n-g-l-e_-d-i-f-f_-c-u-t-o-f-f.md) | `var ANGLE_DIFF_CUTOFF: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
| [CURRENT_LOCATION_RADIUS_PIXELS](-c-u-r-r-e-n-t_-l-o-c-a-t-i-o-n_-r-a-d-i-u-s_-p-i-x-e-l-s.md) | `val CURRENT_LOCATION_RADIUS_PIXELS: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [DESIRED_PATH_COLOR](-d-e-s-i-r-e-d_-p-a-t-h_-c-o-l-o-r.md) | `val DESIRED_PATH_COLOR: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [MIN_SPEED](-m-i-n_-s-p-e-e-d.md) | `var MIN_SPEED: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [PATH_WIDTH_IN_PIXELS](-p-a-t-h_-w-i-d-t-h_-i-n_-p-i-x-e-l-s.md) | `val PATH_WIDTH_IN_PIXELS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_PATH_COLOR](-s-e-n-s-o-r_-p-a-t-h_-c-o-l-o-r.md) | `val SENSOR_PATH_COLOR: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [setAngleDiff](set-angle-diff.md) | `fun setAngleDiff(angle: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setMinSpeed](set-min-speed.md) | `fun setMinSpeed(speed: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setMultiplier](set-multiplier.md) | `fun setMultiplier(multiplier: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [bindView](../../hwp.basketball.mobility.util/android.view.-view/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`View`](https://developer.android.com/reference/android/view/View.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewBinder`](../../hwp.basketball.mobility.util/-view-binder/index.md)`<T>` |
