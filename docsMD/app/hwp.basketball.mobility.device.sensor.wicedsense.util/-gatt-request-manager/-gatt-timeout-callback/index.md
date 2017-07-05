[app](../../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.util](../../index.md) / [GattRequestManager](../index.md) / [GattTimeoutCallback](.)

# GattTimeoutCallback

`interface GattTimeoutCallback`

### Functions

| Name | Summary |
|---|---|
| [onTimeout](on-timeout.md) | `abstract fun onTimeout(request: `[`GattRequest`](../-gatt-request/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [OtaAppInfoReader](../../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info-reader/index.md) | `open class OtaAppInfoReader : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, GattTimeoutCallback` |
| [OtaManager](../../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-manager/index.md) | `open class OtaManager : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, GattTimeoutCallback` |
