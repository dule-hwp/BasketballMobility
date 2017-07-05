[app](../../index.md) / [hwp.basketball.mobility](../index.md) / [BasePresenter](.)

# BasePresenter

`interface BasePresenter`

Created by dusan_cvetkovic on 3/28/17.

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LoginPresenter](../../hwp.basketball.mobility.login/-login-presenter/index.md) | `class LoginPresenter : `[`Presenter`](../../hwp.basketball.mobility.login/-login-contract/-presenter/index.md)`, `[`Callback`](../../hwp.basketball.mobility.login/-login-contract/-interactor/-callback/index.md)`, BasePresenter`<br>Created by dusan_cvetkovic on 3/23/17. |
| [Presenter](../../hwp.basketball.mobility.drill.create/-drill-activity-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.connectplayers/-connect-players-contract/-presenter/index.md) | `interface Presenter : BasePresenter, `[`SensorChooserCallback`](../../hwp.basketball.mobility.sensortilescan/-sensors-dialog/-sensor-chooser-callback/index.md) |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.selectdrill/-drills-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.selectplayers/-players-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.pathrecorder/-path-recorder-activity-contract/-presenter.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.pathrecorder.sketchview/-sensor-drawing-view-view-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
