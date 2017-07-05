[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../index.md) / [DevicePickerActivity](.)

# DevicePickerActivity

`open class DevicePickerActivity : `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`, `[`Callback`](../-device-list-fragment/-callback/index.md)`, `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)

Container activity used to display the device picker

**Author**
fredc

### Constructors

| [&lt;init&gt;](-init-.md) | `DevicePickerActivity()`<br>Container activity used to display the device picker |

### Functions

| [canAddDevice](can-add-device.md) | `open fun canAddDevice(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onClick](on-click.md) | `open fun onClick(v: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `open fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDevicePicked](on-device-picked.md) | `open fun onDevicePicked(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `open fun onError(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

