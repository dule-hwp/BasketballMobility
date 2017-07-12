[app](../../index.md) / [hwp.basketball.mobility.util](../index.md) / [android.graphics.Path](index.md) / [moveTo](.)

# moveTo

`fun `[`Path`](https://developer.android.com/reference/android/graphics/Path.html)`.moveTo(point: `[`PointF`](../-point-f/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set the beginning of the next contour to the [PointF](../-point-f/index.md) point.

Path "Move to point" extension function.
Instead of to x and y coordinates.

``` kotlin
val path = Path()
val start = pathViewPoints[i]
val end = pathViewPoints[i + 1]
path.moveTo(start)
path.lineTo(end)
val angle = start.getAngle(end)
return Pair(PathMeasure(path, false).length + previousLength, angle)
```

**Parameters**

