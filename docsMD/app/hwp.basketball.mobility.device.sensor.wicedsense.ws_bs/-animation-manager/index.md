[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](../index.md) / [AnimationManager](.)

# AnimationManager

`open class AnimationManager`

Manages and coordinates multiple "Animated" objects

### Types

| [Animated](-animated/index.md) | `interface Animated : `[`AnimatorUpdateListener`](https://developer.android.com/reference/android/animation/ValueAnimator/AnimatorUpdateListener.html) |

### Constructors

| [&lt;init&gt;](-init-.md) | `AnimationManager(frameDelayMs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, animateIntervalMs: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)` |

### Functions

| [addAnimated](add-animated.md) | `open fun addAnimated(a: `[`Animated`](-animated/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [animate](animate.md) | `open fun animate(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [init](init.md) | `open fun init(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [prepareAnimated](prepare-animated.md) | `open fun prepareAnimated(a: `[`Animated`](-animated/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [removeAnimated](remove-animated.md) | `open fun removeAnimated(a: `[`Animated`](-animated/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [useAnimation](use-animation.md) | `open fun useAnimation(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

