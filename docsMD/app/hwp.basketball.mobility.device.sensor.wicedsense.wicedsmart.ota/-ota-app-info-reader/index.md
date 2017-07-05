[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota](../index.md) / [OtaAppInfoReader](.)

# OtaAppInfoReader

`open class OtaAppInfoReader : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, `[`GattTimeoutCallback`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-gatt-timeout-callback/index.md)

### Types

| Name | Summary |
|---|---|
| [Callback](-callback/index.md) | `interface Callback` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OtaAppInfoReader(cb: `[`Callback`](-callback/index.md)`)`<br>`OtaAppInfoReader(cb: `[`Callback`](-callback/index.md)`, l: `[`Looper`](https://developer.android.com/reference/android/os/Looper.html)`)` |

### Functions

| Name | Summary |
|---|---|
| [finish](finish.md) | `open fun finish(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleMessage](handle-message.md) | `open fun handleMessage(msg: `[`Message`](https://developer.android.com/reference/android/os/Message.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [initServicesAndCharacteristics](init-services-and-characteristics.md) | `open fun initServicesAndCharacteristics(mgr: `[`GattRequestManager`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/index.md)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onCharacteristicRead](on-characteristic-read.md) | `open fun onCharacteristicRead(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, characteristic: `[`BluetoothGattCharacteristic`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onTimeout](on-timeout.md) | `open fun onTimeout(request: `[`GattRequest`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-gatt-request/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [read](read.md) | `open fun read(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
