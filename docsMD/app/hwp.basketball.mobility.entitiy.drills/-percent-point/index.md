[app](../../index.md) / [hwp.basketball.mobility.entitiy.drills](../index.md) / [PercentPoint](.)

# PercentPoint

`data class PercentPoint`

Used to support different view sizes where path might ne drawn.

### Constructors

| [&lt;init&gt;](-init-.md) | `PercentPoint(percentX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f, percentY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)` = 0f)`<br>Used to support different view sizes where path might ne drawn. |

### Properties

| [percentX](percent-x.md) | `var percentX: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [percentY](percent-y.md) | `var percentY: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |

### Functions

| [toViewPoint](to-view-point.md) | `fun toViewPoint(view: `[`ViewDimens`](../-view-dimens/index.md)`): `[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md) |

### Companion Object Functions

| [fromViewPoint](from-view-point.md) | `fun fromViewPoint(point: `[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md)`, viewDimens: `[`ViewDimens`](../-view-dimens/index.md)`): PercentPoint` |

