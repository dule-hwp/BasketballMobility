[app](../../index.md) / [hwp.basketball.mobility.util](../index.md) / [android.graphics.PathMeasure](index.md) / [getPointAtDistance](.)

# getPointAtDistance

`fun `[`PathMeasure`](https://developer.android.com/reference/android/graphics/PathMeasure.html)`.getPointAtDistance(distance: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, point: `[`PointF`](../-point-f/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Pins distance to 0 &lt;= distance &lt;= getLength(), and then computes the
corresponding position. Returns false if there is no path,
or a zero-length path was specified, in which case position is unchanged.

``` kotlin
//Unresolved: sampleGetPointAtDistance
```

### Parameters

`distance` - The distance along the current contour to sample

`point` - returns the sampled position point

**Return**
false if there was no path associated with this measure object

