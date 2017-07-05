[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota](../index.md) / [OtaCallback](.)

# OtaCallback

`interface OtaCallback`

### Functions

| [onOtaAborted](on-ota-aborted.md) | `abstract fun onOtaAborted(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOtaError](on-ota-error.md) | `abstract fun onOtaError(state: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, errorCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOtaStateChanged](on-ota-state-changed.md) | `abstract fun onOtaStateChanged(state: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOtaUploadProgress](on-ota-upload-progress.md) | `abstract fun onOtaUploadProgress(loopCount: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, bytesCurrent: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, bytesTotal: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

