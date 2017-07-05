[app](../../index.md) / [hwp.basketball.mobility.pathrecorder.sketchview](../index.md) / [SensorDrawingView](index.md) / [movingAverageLinearAcc](.)

# movingAverageLinearAcc

`val movingAverageLinearAcc: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`MovingAverage`](../../hwp.basketball.mobility.util/-moving-average/index.md)`>`

Array (for each axis value) of moving average windows

Used for averaging acceleration values after removing gravity.

Note: values kept here are in mG. before applying some math to it make sure to convert to

