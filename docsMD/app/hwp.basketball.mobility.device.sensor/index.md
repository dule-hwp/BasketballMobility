[app](../index.md) / [hwp.basketball.mobility.device.sensor](.)

## Package hwp.basketball.mobility.device.sensor

All of the sensors supported by the application should be inside this package and have their own sub packege. In this packege root we can find BaseSensor that each of the sensors need to implement and we have sensor factory (factory pattern) to build specific sensor implementation based on type.

### Types

| Name | Summary |
|---|---|
| [BMSensorManager](-b-m-sensor-manager/index.md) | `class BMSensorManager : `[`IBMSensorManager`](-i-b-m-sensor-manager/index.md)`, `[`SensorStateChangedCallback`](-base-sensor/-sensor-state-changed-callback/index.md)<br>Created by dusan_cvetkovic on 4/7/17. |
| [BaseSensor](-base-sensor/index.md) | `abstract class BaseSensor`<br>Each of the sensors needs to extend this class and implement required methods. |
| [IBMSensorManager](-i-b-m-sensor-manager/index.md) | `interface IBMSensorManager`<br>Created by dusan_cvetkovic on 5/21/17. |
| [SensorFactory](-sensor-factory/index.md) | `class SensorFactory`<br>Created by dusan_cvetkovic on 5/28/17. |
