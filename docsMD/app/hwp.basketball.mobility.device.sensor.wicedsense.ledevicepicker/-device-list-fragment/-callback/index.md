[app](../../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../../index.md) / [DeviceListFragment](../index.md) / [Callback](.)

# Callback

`interface Callback`

### Functions

| [canAddDevice](can-add-device.md) | `abstract fun canAddDevice(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onDevicePicked](on-device-picked.md) | `abstract fun onDevicePicked(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `abstract fun onError(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [DevicePickerActivity](../../-device-picker-activity/index.md) | `open class DevicePickerActivity : `[`Activity`](https://developer.android.com/reference/android/app/Activity.html)`, Callback, `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)<br>Container activity used to display the device picker |
| [DevicePickerFragment](../../-device-picker-fragment/index.md) | `open class DevicePickerFragment : `[`DialogFragment`](https://developer.android.com/reference/android/app/DialogFragment.html)`, `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)`, `[`OnShowListener`](https://developer.android.com/reference/android/content/DialogInterface/OnShowListener.html)`, Callback`<br>Not used |

