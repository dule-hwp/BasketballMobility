[app](../../index.md) / [hwp.basketball.mobility.drill.create](../index.md) / [DrillActivityPresenter](.)

# DrillActivityPresenter

`class DrillActivityPresenter : `[`Presenter`](../-drill-activity-contract/-presenter/index.md)

Created by dusan_cvetkovic on 4/19/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillActivityPresenter(view: `[`View`](../-drill-activity-contract/-view/index.md)`)`<br>Created by dusan_cvetkovic on 4/19/17. |

### Properties

| Name | Summary |
|---|---|
| [compositeDisposable](composite-disposable.md) | `val compositeDisposable: CompositeDisposable` |
| [drillsDataStore](drills-data-store.md) | `val drillsDataStore: `[`DrillsDataStore`](../../hwp.basketball.mobility.entitiy.drills/-drills-data-store/index.md) |
| [view](view.md) | `val view: `[`View`](../-drill-activity-contract/-view/index.md) |

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |
| [onDoneTap](on-done-tap.md) | `fun onDoneTap(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillDataFilled](on-drill-data-filled.md) | `fun onDrillDataFilled(pathPoints: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md)`>, drillName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, numOfPlayers: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, viewDimens: `[`ViewDimens`](../../hwp.basketball.mobility.entitiy.drills/-view-dimens/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Method in charge of adding drill to the database. |
