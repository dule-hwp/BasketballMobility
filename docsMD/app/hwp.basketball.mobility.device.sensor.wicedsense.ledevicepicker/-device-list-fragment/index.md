[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../index.md) / [DeviceListFragment](.)

# DeviceListFragment

`open class DeviceListFragment : `[`ListFragment`](https://developer.android.com/reference/android/app/ListFragment.html)`, `[`LeScanCallback`](https://developer.android.com/reference/android/bluetooth/BluetoothAdapter/LeScanCallback.html)

Displays a list of Bluetooth GATT device

### Types

| Name | Summary |
|---|---|
| [Callback](-callback/index.md) | `interface Callback` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DeviceListFragment()`<br>Displays a list of Bluetooth GATT device |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `open fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onLeScan](on-le-scan.md) | `open fun onLeScan(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`, rssi: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, scanRecord: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onListItemClick](on-list-item-click.md) | `open fun onListItemClick(list: `[`ListView`](https://developer.android.com/reference/android/widget/ListView.html)`, view: `[`View`](https://developer.android.com/reference/android/view/View.html)`, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, id: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [scan](scan.md) | `open fun scan(enable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setCallback](set-callback.md) | `open fun setCallback(cb: `[`Callback`](-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setServiceFilter](set-service-filter.md) | `open fun setServiceFilter(filters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
