[app](../../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../../index.md) / [SenseDeviceState](../index.md) / [EventCallback](.)

# EventCallback

`interface EventCallback`

Event callback interface invoked to report events to interested listeners

### Functions

| [onAppInfoRead](on-app-info-read.md) | `abstract fun onAppInfoRead(deviceState: `[`SenseDeviceState`](../index.md)`, success: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, info: `[`OtaAppInfo`](../../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBatteryStatus](on-battery-status.md) | `abstract fun onBatteryStatus(deviceState: `[`SenseDeviceState`](../index.md)`, batteryLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onConnected](on-connected.md) | `abstract fun onConnected(deviceState: `[`SenseDeviceState`](../index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDisconnected](on-disconnected.md) | `abstract fun onDisconnected(deviceState: `[`SenseDeviceState`](../index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorData](on-sensor-data.md) | `abstract fun onSensorData(deviceState: `[`SenseDeviceState`](../index.md)`, sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onUnsupportedDevice](on-unsupported-device.md) | `abstract fun onUnsupportedDevice(deviceState: `[`SenseDeviceState`](../index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [SenseManager](../../-sense-manager/index.md) | `open class SenseManager : `[`Service`](https://developer.android.com/reference/android/app/Service.html)`, EventCallback`<br>Manages WICED Sense devices. Currently, this application only manages one WICED Sense device at a time. But this can be expanded to support more than one device connection |

