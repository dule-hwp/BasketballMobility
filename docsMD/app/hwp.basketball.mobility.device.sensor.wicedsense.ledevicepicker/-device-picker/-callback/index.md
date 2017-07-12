[app](../../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../../index.md) / [DevicePicker](../index.md) / [Callback](.)

# Callback

`interface Callback`

Callback to receive device picked event

**Author**
fredc

### Functions

| Name | Summary |
|---|---|
| [onDevicePickCancelled](on-device-pick-cancelled.md) | `abstract fun onDevicePickCancelled(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDevicePicked](on-device-picked.md) | `abstract fun onDevicePicked(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [WicedSenseSensor](../../../hwp.basketball.mobility.device.sensor.wicedsense/-wiced-sense-sensor/index.md) | `class WicedSenseSensor : `[`BaseSensor`](../../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)`, Callback, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)<br>Wiced Sense Base Sensor implementation. |
