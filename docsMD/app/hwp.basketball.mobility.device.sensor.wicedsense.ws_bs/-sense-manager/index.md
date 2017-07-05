[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../index.md) / [SenseManager](.)

# SenseManager

`open class SenseManager : `[`Service`](https://developer.android.com/reference/android/app/Service.html)`, `[`EventCallback`](../-sense-device-state/-event-callback/index.md)

Manages WICED Sense devices. Currently, this application only manages one WICED Sense device at a time. But this can be expanded to support more than one device connection

**Author**
fredc

### Constructors

| [&lt;init&gt;](-init-.md) | `SenseManager()`<br>Manages WICED Sense devices. Currently, this application only manages one WICED Sense device at a time. But this can be expanded to support more than one device connection |

### Properties

| [EVENT_APP_INFO](-e-v-e-n-t_-a-p-p_-i-n-f-o.md) | `static val EVENT_APP_INFO: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [EVENT_BATTERY_STATUS](-e-v-e-n-t_-b-a-t-t-e-r-y_-s-t-a-t-u-s.md) | `static val EVENT_BATTERY_STATUS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [EVENT_CONNECTED](-e-v-e-n-t_-c-o-n-n-e-c-t-e-d.md) | `static val EVENT_CONNECTED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [EVENT_DEVICE_UNSUPPORTED](-e-v-e-n-t_-d-e-v-i-c-e_-u-n-s-u-p-p-o-r-t-e-d.md) | `static val EVENT_DEVICE_UNSUPPORTED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [EVENT_DISCONNECTED](-e-v-e-n-t_-d-i-s-c-o-n-n-e-c-t-e-d.md) | `static val EVENT_DISCONNECTED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [EVENT_SENSOR_DATA](-e-v-e-n-t_-s-e-n-s-o-r_-d-a-t-a.md) | `static val EVENT_SENSOR_DATA: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| [connect](connect.md) | `open fun connect(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [destroy](destroy.md) | `open static fun destroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disconnect](disconnect.md) | `open fun disconnect(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [enableNotifications](enable-notifications.md) | `open fun enableNotifications(enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getAppInfo](get-app-info.md) | `open fun getAppInfo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getBatteryStatus](get-battery-status.md) | `open fun getBatteryStatus(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getDevice](get-device.md) | `open fun getDevice(): `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html) |
| [getDeviceState](get-device-state.md) | `open fun getDeviceState(): `[`SenseDeviceState`](../-sense-device-state/index.md) |
| [getGattManager](get-gatt-manager.md) | `open fun getGattManager(): `[`GattRequestManager`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/index.md) |
| [getInstance](get-instance.md) | `open static fun getInstance(): SenseManager?` |
| [init](init.md) | `open static fun init(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [isConnectedAndAvailable](is-connected-and-available.md) | `open fun isConnectedAndAvailable(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [isStarted](is-started.md) | `open fun isStarted(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onAppInfoRead](on-app-info-read.md) | `open fun onAppInfoRead(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`, success: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`, info: `[`OtaAppInfo`](../../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onApplicationMinimized](on-application-minimized.md) | `open fun onApplicationMinimized(minimized: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBatteryStatus](on-battery-status.md) | `open fun onBatteryStatus(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`, batteryLevel: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBind](on-bind.md) | `open fun onBind(intent: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`): `[`IBinder`](https://developer.android.com/reference/android/os/IBinder.html) |
| [onConnected](on-connected.md) | `open fun onConnected(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `open fun onCreate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDestroy](on-destroy.md) | `open fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDisconnected](on-disconnected.md) | `open fun onDisconnected(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorData](on-sensor-data.md) | `open fun onSensorData(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`, sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStartCommand](on-start-command.md) | `open fun onStartCommand(intent: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`, flags: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, startId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onUnsupportedDevice](on-unsupported-device.md) | `open fun onUnsupportedDevice(deviceState: `[`SenseDeviceState`](../-sense-device-state/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [registerEventCallbackHandler](register-event-callback-handler.md) | `open fun registerEventCallbackHandler(callback: `[`Handler`](https://developer.android.com/reference/android/os/Handler.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDevice](set-device.md) | `open fun setDevice(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setOtaUpdateMode](set-ota-update-mode.md) | `open fun setOtaUpdateMode(isOtaUpdateMode: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister for events and unregister for callbacks |
| [stop](stop.md) | `open fun stop(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unregisterEventCallbackHandler](unregister-event-callback-handler.md) | `open fun unregisterEventCallbackHandler(callback: `[`Handler`](https://developer.android.com/reference/android/os/Handler.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

