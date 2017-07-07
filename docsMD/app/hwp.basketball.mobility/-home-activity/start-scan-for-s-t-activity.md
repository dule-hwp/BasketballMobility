[app](../../index.md) / [hwp.basketball.mobility](../index.md) / [HomeActivity](index.md) / [startScanForSTActivity](.)

# startScanForSTActivity

`fun startScanForSTActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Starting the BLE scan for SensorTile activity.
The reason why we put this here and not in SensorTileSensor implementation is because
we want to be able to check activity result and see what user selected.

