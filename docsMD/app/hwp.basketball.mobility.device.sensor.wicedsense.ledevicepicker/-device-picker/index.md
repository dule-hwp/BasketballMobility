[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../index.md) / [DevicePicker](.)

# DevicePicker

`open class DevicePicker`

Helper class to show a device picker dialog and obtain the device selected by the user.

### Types

| Name | Summary |
|---|---|
| [Callback](-callback/index.md) | `interface Callback`<br>Callback to receive device picked event |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DevicePicker(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, launchPackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, launchClassName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, broadcastPackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, broadcastClassName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Create a DevicePicker, and broadcast an intent to the specificed package/class receiver specified`DevicePicker(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, cb: `[`Callback`](-callback/index.md)`, devicePickerDataFilterUri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`)`<br>Create a DevicePicker, automatically register a broadcast receiver, and invoke the callback when the device is picked |

### Properties

| Name | Summary |
|---|---|
| [ACTION_CANCELLED](-a-c-t-i-o-n_-c-a-n-c-e-l-l-e-d.md) | `static val ACTION_CANCELLED: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [ACTION_DEVICE_SELECTED](-a-c-t-i-o-n_-d-e-v-i-c-e_-s-e-l-e-c-t-e-d.md) | `static val ACTION_DEVICE_SELECTED: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Broadcast intent when a BLE device is selected from the BLE device picker screen |
| [ACTION_LAUNCH](-a-c-t-i-o-n_-l-a-u-n-c-h.md) | `static val ACTION_LAUNCH: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EXTRA_DATA](-e-x-t-r-a_-d-a-t-a.md) | `static val EXTRA_DATA: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EXTRA_DEVICE](-e-x-t-r-a_-d-e-v-i-c-e.md) | `static val EXTRA_DEVICE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Extra field containing the picked BluetoothDevice |
| [EXTRA_DEVICE_FILTERS](-e-x-t-r-a_-d-e-v-i-c-e_-f-i-l-t-e-r-s.md) | `static val EXTRA_DEVICE_FILTERS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EXTRA_LAUNCH_CLASS](-e-x-t-r-a_-l-a-u-n-c-h_-c-l-a-s-s.md) | `static val EXTRA_LAUNCH_CLASS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The target class to call when the device is picked |
| [EXTRA_LAUNCH_PACKAGE](-e-x-t-r-a_-l-a-u-n-c-h_-p-a-c-k-a-g-e.md) | `static val EXTRA_LAUNCH_PACKAGE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EXTRA_SERVICE_FILTERS](-e-x-t-r-a_-s-e-r-v-i-c-e_-f-i-l-t-e-r-s.md) | `static val EXTRA_SERVICE_FILTERS: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [EXTRA_START_SCANNING](-e-x-t-r-a_-s-t-a-r-t_-s-c-a-n-n-i-n-g.md) | `static val EXTRA_START_SCANNING: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>The target package to call when the device is picked |
| [EXTRA_TITLE](-e-x-t-r-a_-t-i-t-l-e.md) | `static val EXTRA_TITLE: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [cleanup](cleanup.md) | `open fun cleanup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Cleanup device picker resources |
| [createLaunchIntent](create-launch-intent.md) | `open static fun createLaunchIntent(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, dataUri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`, deviceFilters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, serviceUuids: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)<br>Create a Device Picker Launch Intent |
| [createResultIntentFilter](create-result-intent-filter.md) | `open static fun createResultIntentFilter(filterUri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`): `[`IntentFilter`](https://developer.android.com/reference/android/content/IntentFilter.html)<br>Create a Device Picker Broadcast Receiver filter that filters for the data uri |
| [init](init.md) | `open fun init(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Initializes device picker resources |
| [launch](launch.md) | `open fun launch(title: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, deviceFilters: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, serviceUuids: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>, context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Launches the device picker. Returns false if Bluetooth is not available |
