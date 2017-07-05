[app](../../../index.md) / [hwp.basketball.mobility.pathrecorder.sketchview](../../index.md) / [SensorDrawingViewViewContract](../index.md) / [View](.)

# View

`interface View`

### Functions

| [addAccData](add-acc-data.md) | `abstract fun addAccData(accData: `[`AccData`](../../../hwp.basketball.mobility.device.sensor/-b-m-sensor-manager/-acc-data/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getBitmap](get-bitmap.md) | `abstract fun getBitmap(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html) |
| [getBitmapArea](get-bitmap-area.md) | `abstract fun getBitmapArea(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html) |
| [getDesiredPathLength](get-desired-path-length.md) | `abstract fun getDesiredPathLength(): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [invalidate](invalidate.md) | `abstract fun invalidate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [invalidateView](invalidate-view.md) | `abstract fun invalidateView(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onRecordingModeChange](on-recording-mode-change.md) | `abstract fun onRecordingModeChange(inRecordingMode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorConnected](on-sensor-connected.md) | `abstract fun onSensorConnected(bmSensorManager: `[`IBMSensorManager`](../../../hwp.basketball.mobility.device.sensor/-i-b-m-sensor-manager/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorDisconnected](on-sensor-disconnected.md) | `abstract fun onSensorDisconnected(bmSensorManager: `[`IBMSensorManager`](../../../hwp.basketball.mobility.device.sensor/-i-b-m-sensor-manager/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [resetDrill](reset-drill.md) | `abstract fun resetDrill(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDegreesToNorth](set-degrees-to-north.md) | `abstract fun setDegreesToNorth(degreesToTrueNorth: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setIsMoving](set-is-moving.md) | `abstract fun setIsMoving(isMoving: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setPresenter](set-presenter.md) | `abstract fun setPresenter(sensorDrawingViewPresenter: `[`Presenter`](../-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showToastMessage](show-toast-message.md) | `abstract fun showToastMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [SensorDrawingView](../../-sensor-drawing-view/index.md) | `class SensorDrawingView : `[`View`](https://developer.android.com/reference/android/view/View.html)`, View` |

