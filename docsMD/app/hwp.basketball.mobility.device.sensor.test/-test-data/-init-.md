[app](../../index.md) / [hwp.basketball.mobility.device.sensor.test](../index.md) / [TestData](index.md) / [&lt;init&gt;](.)

# &lt;init&gt;

`TestData(featureName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, sample: Sample)`

Class intended to be used for representing test sensor data.

Idea is to store sensor data while performing the drill and then use it inside mocked sensor
for writing automated tests. Problem is that sensors are asynchronous by nature and
using this kind of that would be synchronous if used with some collection or list.
Maybe using timeout to in background thread and spew data in test, but very hard to
make it work, had enough of it. Next time will make it work.

