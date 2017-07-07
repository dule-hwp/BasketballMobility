[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BaseSensor](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`BaseSensor()`

Each of the sensors needs to extend this class and implement required methods.

After sensor is connected during drill preparation phase, connecting to sensor should be done
via uuid which is argument passed to [connectTo](connect-to.md) method.

Implementation of this class should trigger each of the listeners to inform sensor user what data has changed.

Note that connection to sensor should be done separatelly, because each of the BLE sensors
has its own SDK and connecting/searching for devices is done differently for each wearable sensor.

**See Also**

[connectTo](connect-to.md)

[angleListener](angle-listener.md)

[accelerometerListener](accelerometer-listener.md)

