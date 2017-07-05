[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../index.md) / [SenseDeviceState](.)

# SenseDeviceState

`open class SenseDeviceState : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, `[`LePairingCallback`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-le-pairing-callback/index.md)`, `[`Callback`](../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info-reader/-callback/index.md)

Manages the connection and service/characteristics to a WICED Sense Device

### Types

| Name | Summary |
|---|---|
| [EventCallback](-event-callback/index.md) | `interface EventCallback`<br>Event callback interface invoked to report events to interested listeners |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SenseDeviceState(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`, l: `[`Looper`](https://developer.android.com/reference/android/os/Looper.html)`, cb: `[`EventCallback`](-event-callback/index.md)`)` |

### Functions

| Name | Summary |
|---|---|
| [enableNotifications](enable-notifications.md) | `open fun enableNotifications(enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAppInfoReader](get-app-info-reader.md) | `open fun getAppInfoReader(): `[`OtaAppInfoReader`](../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info-reader/index.md) |
| [getBatteryStatus](get-battery-status.md) | `open fun getBatteryStatus(delayed: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDevice](get-device.md) | `open fun getDevice(): `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html) |
| [getGattManager](get-gatt-manager.md) | `open fun getGattManager(): `[`GattRequestManager`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/index.md) |
| [handleMessage](handle-message.md) | `open fun handleMessage(msg: `[`Message`](https://developer.android.com/reference/android/os/Message.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isConnectedAndAvailable](is-connected-and-available.md) | `open fun isConnectedAndAvailable(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onAppInfoRead](on-app-info-read.md) | `open fun onAppInfoRead(success: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, info: `[`OtaAppInfo`](../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCharacteristicChanged](on-characteristic-changed.md) | `open fun onCharacteristicChanged(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, characteristic: `[`BluetoothGattCharacteristic`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCharacteristicRead](on-characteristic-read.md) | `open fun onCharacteristicRead(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, characteristic: `[`BluetoothGattCharacteristic`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onConnectionStateChange](on-connection-state-change.md) | `open fun onConnectionStateChange(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, newState: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDescriptorWrite](on-descriptor-write.md) | `open fun onDescriptorWrite(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, descriptor: `[`BluetoothGattDescriptor`](https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onPaired](on-paired.md) | `open fun onPaired(paired: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onServicesDiscovered](on-services-discovered.md) | `open fun onServicesDiscovered(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [pairIfNeeded](pair-if-needed.md) | `open fun pairIfNeeded(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
