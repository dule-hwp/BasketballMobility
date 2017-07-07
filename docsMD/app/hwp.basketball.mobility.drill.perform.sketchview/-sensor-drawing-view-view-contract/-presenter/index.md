[app](../../../index.md) / [hwp.basketball.mobility.drill.perform.sketchview](../../index.md) / [SensorDrawingViewViewContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter : `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)

### Functions

| Name | Summary |
|---|---|
| [disableSensorsUpdate](disable-sensors-update.md) | `abstract fun disableSensorsUpdate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [displayStats](display-stats.md) | `abstract fun displayStats(statistics: `[`ArrayList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-array-list/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillCompleted](on-drill-completed.md) | `abstract fun onDrillCompleted(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onPlayPauseDrillClick](on-play-pause-drill-click.md) | `abstract fun onPlayPauseDrillClick(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSaveDrillOutcome](on-save-drill-outcome.md) | `abstract fun onSaveDrillOutcome(outcome: `[`DrillOutcome`](../../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [prepareConnectedSensor](prepare-connected-sensor.md) | `abstract fun prepareConnectedSensor(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [restartDrill](restart-drill.md) | `abstract fun restartDrill(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startResumeMovement](start-resume-movement.md) | `abstract fun startResumeMovement(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopMovement](stop-movement.md) | `abstract fun stopMovement(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [attach](../../../hwp.basketball.mobility/-base-presenter/attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](../../../hwp.basketball.mobility/-base-presenter/detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [SensorDrawingViewPresenter](../../-sensor-drawing-view-presenter/index.md) | `class SensorDrawingViewPresenter : Presenter`<br>Created by dusan_cvetkovic on 3/7/17. |
