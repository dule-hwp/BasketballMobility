[app](../../index.md) / [hwp.basketball.mobility.util](../index.md) / [android.view.View](index.md) / [bindView](.)

# bindView

`fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`View`](https://developer.android.com/reference/android/view/View.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewBinder`](../-view-binder/index.md)`<T>`

Type safe find view by id replacement.
It is being called only once and then the value is being read next time.
Much more convenient then having to have a field initialized in onCreate,
can be used while declaring the property.

``` kotlin
//Unresolved: sampleViewBind
```

### Parameters

`T` -

type for safe cast. If cast unsuccessful throws exception in this case, can be changed
to return nullable value.



Usage:

