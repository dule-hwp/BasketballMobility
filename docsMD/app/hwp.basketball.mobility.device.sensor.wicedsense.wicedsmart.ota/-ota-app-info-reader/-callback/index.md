[app](../../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota](../../index.md) / [OtaAppInfoReader](../index.md) / [Callback](.)

# Callback

`interface Callback`

### Functions

| [onAppInfoRead](on-app-info-read.md) | `abstract fun onAppInfoRead(success: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, info: `[`OtaAppInfo`](../../-ota-app-info/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [SenseDeviceState](../../../hwp.basketball.mobility.device.sensor.wicedsense.ws_bs/-sense-device-state/index.md) | `open class SenseDeviceState : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, `[`LePairingCallback`](../../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-le-pairing-callback/index.md)`, Callback`<br>Manages the connection and service/characteristics to a WICED Sense Device |

