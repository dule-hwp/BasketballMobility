[app](../../../index.md) / [hwp.basketball.mobility.drill.create](../../index.md) / [DrillActivityContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter : `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)

### Functions

| Name | Summary |
|---|---|
| [onDoneTap](on-done-tap.md) | `abstract fun onDoneTap(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillDataFilled](on-drill-data-filled.md) | `abstract fun onDrillDataFilled(pathPoints: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PointF`](../../../hwp.basketball.mobility.util/-point-f/index.md)`>, drillName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, numOfPlayers: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, viewDimens: `[`ViewDimens`](../../../hwp.basketball.mobility.entitiy.drills/-view-dimens/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [attach](../../../hwp.basketball.mobility/-base-presenter/attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [detach](../../../hwp.basketball.mobility/-base-presenter/detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |

### Inheritors

| Name | Summary |
|---|---|
| [DrillActivityPresenter](../../-drill-activity-presenter/index.md) | `class DrillActivityPresenter : Presenter`<br>Created by dusan_cvetkovic on 4/19/17. |
