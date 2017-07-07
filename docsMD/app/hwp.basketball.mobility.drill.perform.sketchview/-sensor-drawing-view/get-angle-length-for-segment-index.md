[app](../../index.md) / [hwp.basketball.mobility.drill.perform.sketchview](../index.md) / [SensorDrawingView](index.md) / [getAngleLengthForSegmentIndex](.)

# getAngleLengthForSegmentIndex

`fun getAngleLengthForSegmentIndex(i: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, previousLength: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Pair`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-pair/index.html)`<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`, `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`>`

Method used for calculating distance on path where current segment ends, and angle.
Then returns those values as a pair.

### Parameters

`i` - index of the Start point. It is assumed that each segmen ends at next point.

`previousLength` - Length of the previous segment.

**Return**
Calculated (endDistance, angle) pair for current segment. Length is cumulative, meaning

