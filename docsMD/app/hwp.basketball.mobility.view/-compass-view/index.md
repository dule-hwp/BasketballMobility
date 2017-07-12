[app](../../index.md) / [hwp.basketball.mobility.view](../index.md) / [CompassView](.)

# CompassView

`class CompassView`

Created by dusan_cvetkovic on 6/20/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `CompassView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 6/20/17. |

### Properties

| Name | Summary |
|---|---|
| [isRotating](is-rotating.md) | `var isRotating: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isRotatingObservable](is-rotating-observable.md) | `val isRotatingObservable: PublishSubject<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [movingAverageAngleDiff](moving-average-angle-diff.md) | `var movingAverageAngleDiff: `[`MovingAverage`](../../hwp.basketball.mobility.util/-moving-average/index.md) |

### Functions

| Name | Summary |
|---|---|
| [drawCompass](draw-compass.md) | `fun drawCompass(canvas: `[`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToRotatingChange](subscribe-to-rotating-change.md) | `fun subscribeToRotatingChange(): Observable<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [updateAngle](update-angle.md) | `fun updateAngle(degreesToTrueNorth: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
