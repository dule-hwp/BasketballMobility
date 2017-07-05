[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../index.md) / [DevicePickerFragment](.)

# DevicePickerFragment

`open class DevicePickerFragment : `[`DialogFragment`](https://developer.android.com/reference/android/app/DialogFragment.html)`, `[`OnClickListener`](https://developer.android.com/reference/android/view/View/OnClickListener.html)`, `[`OnShowListener`](https://developer.android.com/reference/android/content/DialogInterface/OnShowListener.html)`, `[`Callback`](../-device-list-fragment/-callback/index.md)

Not used

**Author**
fredc

### Constructors

| [&lt;init&gt;](-init-.md) | `DevicePickerFragment()`<br>Not used |

### Functions

| [canAddDevice](can-add-device.md) | `open fun canAddDevice(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [createDialog](create-dialog.md) | `open static fun createDialog(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceFilters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, serviceFilters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, startScanning: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): DevicePickerFragment` |
| [onClick](on-click.md) | `open fun onClick(v: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateDialog](on-create-dialog.md) | `open fun onCreateDialog(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`Dialog`](https://developer.android.com/reference/android/app/Dialog.html) |
| [onDevicePicked](on-device-picked.md) | `open fun onDevicePicked(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `open fun onError(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onShow](on-show.md) | `open fun onShow(dialog: `[`DialogInterface`](https://developer.android.com/reference/android/content/DialogInterface.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setScanState](set-scan-state.md) | `open fun setScanState(isScanning: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

