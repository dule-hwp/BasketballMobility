[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](../index.md) / [DevicePicker](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`DevicePicker(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, launchPackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, launchClassName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, broadcastPackageName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, broadcastClassName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`

Create a DevicePicker, and broadcast an intent to the specificed package/class receiver specified

### Parameters

`ctx` -

`broadcastPackageName` -

`broadcastClassName` - `DevicePicker(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, cb: `[`Callback`](-callback/index.md)`, devicePickerDataFilterUri: `[`Uri`](https://developer.android.com/reference/android/net/Uri.html)`)`

Create a DevicePicker, automatically register a broadcast receiver, and invoke the callback when the device is picked

### Parameters

`ctx` -

`devicePickerDataFilterUri` -

`cb` - 