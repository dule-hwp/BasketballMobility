[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota](../index.md) / [OtaManager](.)

# OtaManager

`open class OtaManager : `[`BluetoothGattCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCallback.html)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)`, `[`GattTimeoutCallback`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-gatt-timeout-callback/index.md)

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `OtaManager()` |

### Properties

| Name | Summary |
|---|---|
| [ERROR_CHARACTERISTIC_WRITE](-e-r-r-o-r_-c-h-a-r-a-c-t-e-r-i-s-t-i-c_-w-r-i-t-e.md) | `static val ERROR_CHARACTERISTIC_WRITE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_CONNECT](-e-r-r-o-r_-c-o-n-n-e-c-t.md) | `static val ERROR_CONNECT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_DESCRIPTOR_NOT_FOUND](-e-r-r-o-r_-d-e-s-c-r-i-p-t-o-r_-n-o-t_-f-o-u-n-d.md) | `static val ERROR_DESCRIPTOR_NOT_FOUND: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_DESCRIPTOR_WRITE](-e-r-r-o-r_-d-e-s-c-r-i-p-t-o-r_-w-r-i-t-e.md) | `static val ERROR_DESCRIPTOR_WRITE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_DISCOVER](-e-r-r-o-r_-d-i-s-c-o-v-e-r.md) | `static val ERROR_DISCOVER: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_FIRMWARE_INFO_READ](-e-r-r-o-r_-f-i-r-m-w-a-r-e_-i-n-f-o_-r-e-a-d.md) | `static val ERROR_FIRMWARE_INFO_READ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_FIRMWARE_INFO_WRITE](-e-r-r-o-r_-f-i-r-m-w-a-r-e_-i-n-f-o_-w-r-i-t-e.md) | `static val ERROR_FIRMWARE_INFO_WRITE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_FIRMWARE_READ](-e-r-r-o-r_-f-i-r-m-w-a-r-e_-r-e-a-d.md) | `static val ERROR_FIRMWARE_READ: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_FIRMWARE_WRITE](-e-r-r-o-r_-f-i-r-m-w-a-r-e_-w-r-i-t-e.md) | `static val ERROR_FIRMWARE_WRITE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_SERVICE](-e-r-r-o-r_-s-e-r-v-i-c-e.md) | `static val ERROR_SERVICE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [ERROR_TIMEOUT](-e-r-r-o-r_-t-i-m-e-o-u-t.md) | `static val ERROR_TIMEOUT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_ABORTED](-s-t-a-t-e_-a-b-o-r-t-e-d.md) | `static val STATE_ABORTED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_CONNECT](-s-t-a-t-e_-c-o-n-n-e-c-t.md) | `static val STATE_CONNECT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_DISCOVER](-s-t-a-t-e_-d-i-s-c-o-v-e-r.md) | `static val STATE_DISCOVER: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_ENABLE_NOTIFY](-s-t-a-t-e_-e-n-a-b-l-e_-n-o-t-i-f-y.md) | `static val STATE_ENABLE_NOTIFY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_NONE](-s-t-a-t-e_-n-o-n-e.md) | `static val STATE_NONE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_PREPARE_DOWNLOAD](-s-t-a-t-e_-p-r-e-p-a-r-e_-d-o-w-n-l-o-a-d.md) | `static val STATE_PREPARE_DOWNLOAD: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_SEND_FW](-s-t-a-t-e_-s-e-n-d_-f-w.md) | `static val STATE_SEND_FW: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_SEND_FW_COMPLETED](-s-t-a-t-e_-s-e-n-d_-f-w_-c-o-m-p-l-e-t-e-d.md) | `static val STATE_SEND_FW_COMPLETED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_SEND_FW_INFO](-s-t-a-t-e_-s-e-n-d_-f-w_-i-n-f-o.md) | `static val STATE_SEND_FW_INFO: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_START_DOWNLOAD](-s-t-a-t-e_-s-t-a-r-t_-d-o-w-n-l-o-a-d.md) | `static val STATE_START_DOWNLOAD: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_UPGRADE_COMPLETED](-s-t-a-t-e_-u-p-g-r-a-d-e_-c-o-m-p-l-e-t-e-d.md) | `static val STATE_UPGRADE_COMPLETED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [STATE_VERIFY_FW](-s-t-a-t-e_-v-e-r-i-f-y_-f-w.md) | `static val STATE_VERIFY_FW: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_ILLEGAL_STATE](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-i-l-l-e-g-a-l_-s-t-a-t-e.md) | `static val WS_UPGRADE_STATUS_ILLEGAL_STATE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_INVALID_APPID](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-i-n-v-a-l-i-d_-a-p-p-i-d.md) | `static val WS_UPGRADE_STATUS_INVALID_APPID: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_INVALID_IMAGE](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-i-n-v-a-l-i-d_-i-m-a-g-e.md) | `static val WS_UPGRADE_STATUS_INVALID_IMAGE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_INVALID_IMAGE_SIZE](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-i-n-v-a-l-i-d_-i-m-a-g-e_-s-i-z-e.md) | `static val WS_UPGRADE_STATUS_INVALID_IMAGE_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_INVALID_VERSION](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-i-n-v-a-l-i-d_-v-e-r-s-i-o-n.md) | `static val WS_UPGRADE_STATUS_INVALID_VERSION: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_MORE_DATA](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-m-o-r-e_-d-a-t-a.md) | `static val WS_UPGRADE_STATUS_MORE_DATA: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_OK](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-o-k.md) | `static val WS_UPGRADE_STATUS_OK: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_UNSUPPORTED_COMMAND](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-u-n-s-u-p-p-o-r-t-e-d_-c-o-m-m-a-n-d.md) | `static val WS_UPGRADE_STATUS_UNSUPPORTED_COMMAND: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_STATUS_VERIFICATION_FAILED](-w-s_-u-p-g-r-a-d-e_-s-t-a-t-u-s_-v-e-r-i-f-i-c-a-t-i-o-n_-f-a-i-l-e-d.md) | `static val WS_UPGRADE_STATUS_VERIFICATION_FAILED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_ABORTED](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-a-b-o-r-t-e-d.md) | `static val WS_UPGRADE_WRITE_STATUS_ABORTED: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_BAD_ID](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-b-a-d_-i-d.md) | `static val WS_UPGRADE_WRITE_STATUS_BAD_ID: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_BAD_MAJOR](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-b-a-d_-m-a-j-o-r.md) | `static val WS_UPGRADE_WRITE_STATUS_BAD_MAJOR: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_SUCCESS](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-s-u-c-c-e-s-s.md) | `static val WS_UPGRADE_WRITE_STATUS_SUCCESS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_TOO_MUCH_DATA](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-t-o-o_-m-u-c-h_-d-a-t-a.md) | `static val WS_UPGRADE_WRITE_STATUS_TOO_MUCH_DATA: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [WS_UPGRADE_WRITE_STATUS_TOO_SHORT](-w-s_-u-p-g-r-a-d-e_-w-r-i-t-e_-s-t-a-t-u-s_-t-o-o_-s-h-o-r-t.md) | `static val WS_UPGRADE_WRITE_STATUS_TOO_SHORT: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |

### Functions

| Name | Summary |
|---|---|
| [abortUpdate](abort-update.md) | `open fun abortUpdate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [addCallback](add-callback.md) | `open fun addCallback(cb: `[`OtaCallback`](../-ota-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [finish](finish.md) | `open fun finish(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getStateString](get-state-string.md) | `static fun getStateString(state: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [getStatusString](get-status-string.md) | `static fun getStatusString(status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [handleMessage](handle-message.md) | `open fun handleMessage(msg: `[`Message`](https://developer.android.com/reference/android/os/Message.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onCharacteristicChanged](on-characteristic-changed.md) | `open fun onCharacteristicChanged(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, characteristic: `[`BluetoothGattCharacteristic`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCharacteristicWrite](on-characteristic-write.md) | `open fun onCharacteristicWrite(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, characteristic: `[`BluetoothGattCharacteristic`](https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onConnectionStateChange](on-connection-state-change.md) | `open fun onConnectionStateChange(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, newState: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>GATT client callbacks |
| [onDescriptorWrite](on-descriptor-write.md) | `open fun onDescriptorWrite(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, descriptor: `[`BluetoothGattDescriptor`](https://developer.android.com/reference/android/bluetooth/BluetoothGattDescriptor.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onServicesDiscovered](on-services-discovered.md) | `open fun onServicesDiscovered(gatt: `[`BluetoothGatt`](https://developer.android.com/reference/android/bluetooth/BluetoothGatt.html)`, status: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onTimeout](on-timeout.md) | `open fun onTimeout(request: `[`GattRequest`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/-gatt-request/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeCallback](remove-callback.md) | `open fun removeCallback(cb: `[`OtaCallback`](../-ota-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDisconnectOnFinished](set-disconnect-on-finished.md) | `open fun setDisconnectOnFinished(disconnect: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startUpdate](start-update.md) | `open fun startUpdate(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, gattManager: `[`GattRequestManager`](../../hwp.basketball.mobility.device.sensor.wicedsense.util/-gatt-request-manager/index.md)`, firmwareLength: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, in: `[`BufferedInputStream`](https://developer.android.com/reference/java/io/BufferedInputStream.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
