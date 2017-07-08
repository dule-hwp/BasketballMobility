[app](../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](.)

## Package hwp.basketball.mobility.device.sensor.wicedsense.ws_bs

WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk).

### Types

| Name | Summary |
|---|---|
| [AnimationManager](-animation-manager/index.md) | `open class AnimationManager`<br>Manages and coordinates multiple "Animated" objects |
| [BluetoothEnabler](-bluetooth-enabler/index.md) | `open class BluetoothEnabler`<br>Helper class to display a dialog requesting the user to turn on Bluetooth, if it is not already turned on |
| [SenseDeviceState](-sense-device-state/index.md) | `open class SenseDeviceState : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, `[`LePairingCallback`](../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-le-pairing-callback/index.md)`, `[`Callback`](../hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/-ota-app-info-reader/-callback/index.md)<br>Manages the connection and service/characteristics to a WICED Sense Device |
| [SenseManager](-sense-manager/index.md) | `open class SenseManager : `[`Service`](https://developer.android.com/reference/android/app/Service.html)`, `[`EventCallback`](-sense-device-state/-event-callback/index.md)<br>Manages WICED Sense devices. Currently, this application only manages one WICED Sense device at a time. But this can be expanded to support more than one device connection |
| [SensorDataParser](-sensor-data-parser/index.md) | `open class SensorDataParser`<br>Helper class to parse the sensor data packets |
| [Settings](-settings/index.md) | `open class Settings`<br>Configurable settings for the WICED Sense Application |
