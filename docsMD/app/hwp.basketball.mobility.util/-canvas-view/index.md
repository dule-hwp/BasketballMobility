[app](../../index.md) / [hwp.basketball.mobility.util](../index.md) / [CanvasView](.)

# CanvasView

`class CanvasView : `[`View`](https://developer.android.com/reference/android/view/View.html)

This class defines fields and methods for drawing.

### Types

| [Drawer](-drawer/index.md) | `enum class Drawer` |
| [Mode](-mode/index.md) | `enum class Mode` |

### Constructors

| [&lt;init&gt;](-init-.md) | `CanvasView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`, defStyle: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`)`<br>`CanvasView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, attrs: `[`AttributeSet`](https://developer.android.com/reference/android/util/AttributeSet.html)`)`<br>`CanvasView(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Copy Constructor |

### Properties

| [blur](blur.md) | `var blur: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [currentPath](current-path.md) | `val currentPath: `[`Path`](https://developer.android.com/reference/android/graphics/Path.html)<br>This method gets the instance of Path that pointer indicates. |
| [drawPathEffect](draw-path-effect.md) | `var drawPathEffect: `[`PathEffect`](https://developer.android.com/reference/android/graphics/PathEffect.html)`?` |
| [drawer](drawer.md) | `var drawer: `[`Drawer`](-drawer/index.md) |
| [fontFamily](font-family.md) | `var fontFamily: `[`Typeface`](https://developer.android.com/reference/android/graphics/Typeface.html) |
| [fontSize](font-size.md) | `var fontSize: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [lineCap](line-cap.md) | `var lineCap: `[`Cap`](https://developer.android.com/reference/android/graphics/Paint/Cap.html) |
| [mode](mode.md) | `var mode: `[`Mode`](-mode/index.md) |
| [opacity](opacity.md) | `var opacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [paintStrokeColor](paint-stroke-color.md) | `var paintStrokeColor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [paintStrokeWidth](paint-stroke-width.md) | `var paintStrokeWidth: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html) |
| [paintStyle](paint-style.md) | `var paintStyle: `[`Style`](https://developer.android.com/reference/android/graphics/Paint/Style.html) |
| [text](text.md) | `var text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Functions

| [canRedo](can-redo.md) | `fun canRedo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method checks if Redo is available |
| [canUndo](can-undo.md) | `fun canUndo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method checks if Undo is available |
| [clear](clear.md) | `fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method initializes canvas. |
| [getBitmap](get-bitmap.md) | `fun getBitmap(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)<br>This method gets current canvas as bitmap. |
| [onDraw](on-draw.md) | `fun onDraw(canvas: `[`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method updates the instance of Canvas (View) |
| [onTouchEvent](on-touch-event.md) | `fun onTouchEvent(event: `[`MotionEvent`](https://developer.android.com/reference/android/view/MotionEvent.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method set event listener for drawing. |
| [redo](redo.md) | `fun redo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method draws canvas again for Redo. |
| [undo](undo.md) | `fun undo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method draws canvas again for Undo. |

### Extension Functions

| [bindView](../android.view.-view/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`View`](https://developer.android.com/reference/android/view/View.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewBinder`](../-view-binder/index.md)`<T>` |

