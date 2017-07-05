[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense](../index.md) / [WicedSenseSensor](index.md) / [handleMessage](.)

# handleMessage

`fun handleMessage(msg: `[`Message`](https://developer.android.com/reference/android/os/Message.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)

Handler callback used for two purposes

1. This callback is invoked by the event handler loop when the
SenseManager service sends a event from the sensor tag using the
mEventHandler object. The event handler loop runs in a child thread, so
that it can queue up events and allow the SenseManager (and Bluetooth
callbacks) to return asynchronously before the UI processes the event.
The event handler loop reposts the event to the main UI handler loop via
the mUiHandler Handler
1. This callback is invoked by the mEventHandler object to run a UI
operation in the main event loop of the application
