[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../index.md) / [SensorDataParser](.)

# SensorDataParser

`open class SensorDataParser`

Helper class to parse the sensor data packets

**Author**
fredc

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SensorDataParser()`<br>Helper class to parse the sensor data packets |

### Properties

| Name | Summary |
|---|---|
| [SENSOR_ACCEL_DATA_SIZE](-s-e-n-s-o-r_-a-c-c-e-l_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_ACCEL_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_ACCEL_MAX](-s-e-n-s-o-r_-a-c-c-e-l_-m-a-x.md) | `static val SENSOR_ACCEL_MAX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_ACCEL_MIN](-s-e-n-s-o-r_-a-c-c-e-l_-m-i-n.md) | `static val SENSOR_ACCEL_MIN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_ACCEL](-s-e-n-s-o-r_-f-l-a-g_-a-c-c-e-l.md) | `static val SENSOR_FLAG_ACCEL: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_GYRO](-s-e-n-s-o-r_-f-l-a-g_-g-y-r-o.md) | `static val SENSOR_FLAG_GYRO: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_HUMIDITY](-s-e-n-s-o-r_-f-l-a-g_-h-u-m-i-d-i-t-y.md) | `static val SENSOR_FLAG_HUMIDITY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_MAGNO](-s-e-n-s-o-r_-f-l-a-g_-m-a-g-n-o.md) | `static val SENSOR_FLAG_MAGNO: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_PRESSURE](-s-e-n-s-o-r_-f-l-a-g_-p-r-e-s-s-u-r-e.md) | `static val SENSOR_FLAG_PRESSURE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_FLAG_TEMP](-s-e-n-s-o-r_-f-l-a-g_-t-e-m-p.md) | `static val SENSOR_FLAG_TEMP: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_GYRO_DATA_SIZE](-s-e-n-s-o-r_-g-y-r-o_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_GYRO_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_GYRO_MAX](-s-e-n-s-o-r_-g-y-r-o_-m-a-x.md) | `static val SENSOR_GYRO_MAX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_GYRO_MIN](-s-e-n-s-o-r_-g-y-r-o_-m-i-n.md) | `static val SENSOR_GYRO_MIN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_HUMD_DATA_SIZE](-s-e-n-s-o-r_-h-u-m-d_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_HUMD_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_HUMIDITY_MAX](-s-e-n-s-o-r_-h-u-m-i-d-i-t-y_-m-a-x.md) | `static val SENSOR_HUMIDITY_MAX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_HUMIDITY_MIN](-s-e-n-s-o-r_-h-u-m-i-d-i-t-y_-m-i-n.md) | `static val SENSOR_HUMIDITY_MIN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_MAGNO_DATA_SIZE](-s-e-n-s-o-r_-m-a-g-n-o_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_MAGNO_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_MAGNO_MAX](-s-e-n-s-o-r_-m-a-g-n-o_-m-a-x.md) | `static val SENSOR_MAGNO_MAX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_MAGNO_MIN](-s-e-n-s-o-r_-m-a-g-n-o_-m-i-n.md) | `static val SENSOR_MAGNO_MIN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_PRESSURE_MAX](-s-e-n-s-o-r_-p-r-e-s-s-u-r-e_-m-a-x.md) | `static val SENSOR_PRESSURE_MAX: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_PRESSURE_MIN](-s-e-n-s-o-r_-p-r-e-s-s-u-r-e_-m-i-n.md) | `static val SENSOR_PRESSURE_MIN: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_PRES_DATA_SIZE](-s-e-n-s-o-r_-p-r-e-s_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_PRES_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_TEMP_DATA_SIZE](-s-e-n-s-o-r_-t-e-m-p_-d-a-t-a_-s-i-z-e.md) | `static val SENSOR_TEMP_DATA_SIZE: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SENSOR_TEMP_MAX_C](-s-e-n-s-o-r_-t-e-m-p_-m-a-x_-c.md) | `static val SENSOR_TEMP_MAX_C: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [SENSOR_TEMP_MAX_F](-s-e-n-s-o-r_-t-e-m-p_-m-a-x_-f.md) | `static val SENSOR_TEMP_MAX_F: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [SENSOR_TEMP_MIN_C](-s-e-n-s-o-r_-t-e-m-p_-m-i-n_-c.md) | `static val SENSOR_TEMP_MIN_C: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [SENSOR_TEMP_MIN_F](-s-e-n-s-o-r_-t-e-m-p_-m-i-n_-f.md) | `static val SENSOR_TEMP_MIN_F: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [TAG](-t-a-g.md) | `static val TAG: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [accelerometerHasChanged](accelerometer-has-changed.md) | `open static fun accelerometerHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getAccelorometerData](get-accelorometer-data.md) | `open static fun getAccelorometerData(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, values: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getCompassAngleDegrees](get-compass-angle-degrees.md) | `open static fun getCompassAngleDegrees(magnometerValues: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getGyroData](get-gyro-data.md) | `open static fun getGyroData(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, values: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getHumidityPercent](get-humidity-percent.md) | `open static fun getHumidityPercent(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getMagnometerData](get-magnometer-data.md) | `open static fun getMagnometerData(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, values: `[`IntArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getPressureMBar](get-pressure-m-bar.md) | `open static fun getPressureMBar(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getTemperatureC](get-temperature-c.md) | `open static fun getTemperatureC(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [getTemperatureF](get-temperature-f.md) | `open static fun getTemperatureF(sensorData: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`, offset: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [gyroHasChanged](gyro-has-changed.md) | `open static fun gyroHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [humidityHasChanged](humidity-has-changed.md) | `open static fun humidityHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [magnetometerHasChanged](magnetometer-has-changed.md) | `open static fun magnetometerHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [pressureHasChanged](pressure-has-changed.md) | `open static fun pressureHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [tempCtoF](temp-cto-f.md) | `open static fun tempCtoF(c: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [tempFtoC](temp-fto-c.md) | `open static fun tempFtoC(f: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`): `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [temperatureHasChanged](temperature-has-changed.md) | `open static fun temperatureHasChanged(mask: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
