[app](../../index.md) / [hwp.basketball.mobility.drill.perform.sketchview](../index.md) / [SensorDrawingView](index.md) / [updateSensorPath](.)

# updateSensorPath

`fun updateSensorPath(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Main method for drawing sensor path.

In charge of:
    checking how far user got in covering the path
    tracking when user goes off the path by measuring the distance from current segment
    recognizing when user gets back to the desired path
    adding points to sensor path
    adding points to error path in the background (used for exporting error area bitmap)

