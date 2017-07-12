[app](../../index.md) / [hwp.basketball.mobility](../index.md) / [BasePresenter](.)

# BasePresenter

`interface BasePresenter`

Each presenter interface should extend this interface.

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [detach](detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |

### Inheritors

| Name | Summary |
|---|---|
| [LoginPresenter](../../hwp.basketball.mobility.account.login/-login-presenter/index.md) | `class LoginPresenter : `[`Presenter`](../../hwp.basketball.mobility.account.login/-login-contract/-presenter/index.md)`, `[`Callback`](../../hwp.basketball.mobility.account.login/-login-contract/-interactor/-callback/index.md)`, BasePresenter`<br>Created by dusan_cvetkovic on 3/23/17. |
| [Presenter](../../hwp.basketball.mobility.drill.create/-drill-activity-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drill.perform/-path-recorder-activity-contract/-presenter.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drill.perform.sketchview/-sensor-drawing-view-view-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.connectplayers/-connect-players-contract/-presenter/index.md) | `interface Presenter : BasePresenter, `[`SensorChooserCallback`](../../hwp.basketball.mobility.device.sensor.sensortile.sensortilescan/-sensors-dialog/-sensor-chooser-callback/index.md) |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.selectdrill/-drills-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
| [Presenter](../../hwp.basketball.mobility.drillpreparation.step.selectplayers/-players-contract/-presenter/index.md) | `interface Presenter : BasePresenter` |
