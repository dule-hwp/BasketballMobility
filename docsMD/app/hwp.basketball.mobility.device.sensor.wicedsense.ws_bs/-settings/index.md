[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../index.md) / [Settings](.)

# Settings

`open class Settings`

Configurable settings for the WICED Sense Application

### Types

| Name | Summary |
|---|---|
| [SettingChangeListener](-setting-change-listener/index.md) | `interface SettingChangeListener` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `Settings()`<br>Configurable settings for the WICED Sense Application |

### Properties

| Name | Summary |
|---|---|
| [ANIMATE_TIME_INTERVAL_MS](-a-n-i-m-a-t-e_-t-i-m-e_-i-n-t-e-r-v-a-l_-m-s.md) | `static var ANIMATE_TIME_INTERVAL_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Period of time gauge values are animated |
| [ANIMATION_FRAME_DELAY_MS](-a-n-i-m-a-t-i-o-n_-f-r-a-m-e_-d-e-l-a-y_-m-s.md) | `static val ANIMATION_FRAME_DELAY_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [BATTERY_STATUS_INTERVAL_MS](-b-a-t-t-e-r-y_-s-t-a-t-u-s_-i-n-t-e-r-v-a-l_-m-s.md) | `static val BATTERY_STATUS_INTERVAL_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Frequency the battery status of the WICED Sense tag should be polled (in msec) |
| [CHECK_FOR_UPDATES_ON_CONNECT](-c-h-e-c-k_-f-o-r_-u-p-d-a-t-e-s_-o-n_-c-o-n-n-e-c-t.md) | `static val CHECK_FOR_UPDATES_ON_CONNECT: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true, a firmware update check will be performed after the WICED Sense tag is connected |
| [CONNECT_AFTER_DEVICE_PICK](-c-o-n-n-e-c-t_-a-f-t-e-r_-d-e-v-i-c-e_-p-i-c-k.md) | `static val CONNECT_AFTER_DEVICE_PICK: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>If true, WICED Sense app automatically connects to the WICED Sense tag after it is picked from the device picker |
| [DBG](-d-b-g.md) | `static val DBG: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Enable debug tracing to adb logcat logs |
| [PACKAGE_NAME](-p-a-c-k-a-g-e_-n-a-m-e.md) | `static val PACKAGE_NAME: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [PAIRING_TIMEOUT_MS](-p-a-i-r-i-n-g_-t-i-m-e-o-u-t_-m-s.md) | `static val PAIRING_TIMEOUT_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [PAIRNG_REQUIRED](-p-a-i-r-n-g_-r-e-q-u-i-r-e-d.md) | `static val PAIRNG_REQUIRED: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Specifies if pairing/encryption is required to WICED Sense tag |
| [REFRESH_INTERVAL_MS](-r-e-f-r-e-s-h_-i-n-t-e-r-v-a-l_-m-s.md) | `static val REFRESH_INTERVAL_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [REFRESH_INTERVAL_SLOWER_MS](-r-e-f-r-e-s-h_-i-n-t-e-r-v-a-l_-s-l-o-w-e-r_-m-s.md) | `static val REFRESH_INTERVAL_SLOWER_MS: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [SERVICE_DISCOVERY_RETRY](-s-e-r-v-i-c-e_-d-i-s-c-o-v-e-r-y_-r-e-t-r-y.md) | `static val SERVICE_DISCOVERY_RETRY: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Number of retry attempts if BLE service discovery of the WICED Sense tag fails |
| [SERVICE_INIT_TIMEOUT_MS](-s-e-r-v-i-c-e_-i-n-i-t_-t-i-m-e-o-u-t_-m-s.md) | `static val SERVICE_INIT_TIMEOUT_MS: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>Timeout to wait for a connection to the SenseManager service |
| [TAG_PREFIX](-t-a-g_-p-r-e-f-i-x.md) | `static val TAG_PREFIX: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>String contant that all adb logcat messages will be prefixed with (to simplify filtering) |
| [TEMPERATURE_SCALE_TYPE_C](-t-e-m-p-e-r-a-t-u-r-e_-s-c-a-l-e_-t-y-p-e_-c.md) | `static val TEMPERATURE_SCALE_TYPE_C: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [TEMPERATURE_SCALE_TYPE_F](-t-e-m-p-e-r-a-t-u-r-e_-s-c-a-l-e_-t-y-p-e_-f.md) | `static val TEMPERATURE_SCALE_TYPE_F: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| Name | Summary |
|---|---|
| [addChangeListener](add-change-listener.md) | `open static fun addChangeListener(l: `[`SettingChangeListener`](-setting-change-listener/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [finish](finish.md) | `open static fun finish(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [init](init.md) | `open static fun init(ctx: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeChangeListener](remove-change-listener.md) | `open static fun removeChangeListener(l: `[`SettingChangeListener`](-setting-change-listener/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
