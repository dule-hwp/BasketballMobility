[app](../../index.md) / [hwp.basketball.mobility.pathrecorder.sketchview](../index.md) / [SensorDrawingViewPresenter](.)

# SensorDrawingViewPresenter

`class SensorDrawingViewPresenter : `[`Presenter`](../-sensor-drawing-view-view-contract/-presenter/index.md)

Created by dusan_cvetkovic on 3/7/17.

### Constructors

| [&lt;init&gt;](-init-.md) | `SensorDrawingViewPresenter(sensorDrawingViewView: `[`View`](../-sensor-drawing-view-view-contract/-view/index.md)`, sensor: `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)`, pathRecorderActivityView: `[`View`](../../hwp.basketball.mobility.pathrecorder/-path-recorder-activity-contract/-view/index.md)`)`<br>Created by dusan_cvetkovic on 3/7/17. |

### Properties

| [inRecordingMode](in-recording-mode.md) | `var inRecordingMode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [outcomeDataStore](outcome-data-store.md) | `val outcomeDataStore: `[`DrillOutcomeStore`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome-store/index.md) |
| [pathRecorderActivityView](path-recorder-activity-view.md) | `val pathRecorderActivityView: `[`View`](../../hwp.basketball.mobility.pathrecorder/-path-recorder-activity-contract/-view/index.md) |
| [sensor](sensor.md) | `val sensor: `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md) |
| [sensorDrawingViewView](sensor-drawing-view-view.md) | `val sensorDrawingViewView: `[`View`](../-sensor-drawing-view-view-contract/-view/index.md) |

### Functions

| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disableSensorsUpdate](disable-sensors-update.md) | `fun disableSensorsUpdate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [displayStats](display-stats.md) | `fun displayStats(statistics: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [enableRequiredSensorsUpdate](enable-required-sensors-update.md) | `fun enableRequiredSensorsUpdate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isInRecordingMode](is-in-recording-mode.md) | `fun isInRecordingMode(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onDrillCompleted](on-drill-completed.md) | `fun onDrillCompleted(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSaveDrillOutcome](on-save-drill-outcome.md) | `fun onSaveDrillOutcome(outcome: `[`DrillOutcome`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [prepareConnectedSensor](prepare-connected-sensor.md) | `fun prepareConnectedSensor(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [restartDrill](restart-drill.md) | `fun restartDrill(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [saveRecording](save-recording.md) | `fun saveRecording(suffix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startResumeMovement](start-resume-movement.md) | `fun startResumeMovement(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopMovement](stop-movement.md) | `fun stopMovement(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
