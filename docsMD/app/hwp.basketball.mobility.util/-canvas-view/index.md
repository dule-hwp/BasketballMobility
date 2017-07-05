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

| [baseColor](base-color.md) | `var baseColor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is setter for canvas background color |
| [bitmapAsByteArray](bitmap-as-byte-array.md) | `val bitmapAsByteArray: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>This method gets the bitmap as byte array. Bitmap format is PNG, and quality is 100. |
| [blur](blur.md) | `var blur: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>This method is setter for amount of blur. The 1st argument is greater than or equal to 0.0. |
| [currentPath](current-path.md) | `val currentPath: `[`Path`](https://developer.android.com/reference/android/graphics/Path.html)<br>This method gets the instance of Path that pointer indicates. |
| [drawPathEffect](draw-path-effect.md) | `var drawPathEffect: `[`PathEffect`](https://developer.android.com/reference/android/graphics/PathEffect.html)`?`<br>This method is setter for path effect of drawing. |
| [drawer](drawer.md) | `var drawer: `[`Drawer`](-drawer/index.md)<br>This method is setter for drawer. |
| [fontFamily](font-family.md) | `var fontFamily: `[`Typeface`](https://developer.android.com/reference/android/graphics/Typeface.html)<br>This method is setter for font-family. |
| [fontSize](font-size.md) | `var fontSize: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>This method is setter for font size. The 1st argument is greater than or equal to 0.0. |
| [lineCap](line-cap.md) | `var lineCap: `[`Cap`](https://developer.android.com/reference/android/graphics/Paint/Cap.html)<br>This method is setter for line cap. |
| [mode](mode.md) | `var mode: `[`Mode`](-mode/index.md)<br>This method is setter for mode. |
| [opacity](opacity.md) | `var opacity: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is setter for alpha. The 1st argument must be between 0 and 255. |
| [paintFillColor](paint-fill-color.md) | `var paintFillColor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is setter for fill color. But, current Android API cannot set fill color (?). |
| [paintStrokeColor](paint-stroke-color.md) | `var paintStrokeColor: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>This method is setter for stroke color. |
| [paintStrokeWidth](paint-stroke-width.md) | `var paintStrokeWidth: `[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>This method is setter for stroke width. |
| [paintStyle](paint-style.md) | `var paintStyle: `[`Style`](https://developer.android.com/reference/android/graphics/Paint/Style.html)<br>This method is setter for stroke or fill. |
| [text](text.md) | `var text: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>This method is setter for drawn text. |

### Functions

| [canRedo](can-redo.md) | `fun canRedo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method checks if Redo is available |
| [canUndo](can-undo.md) | `fun canUndo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method checks if Undo is available |
| [clear](clear.md) | `fun clear(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method initializes canvas. |
| [drawBitmap](draw-bitmap.md) | `fun drawBitmap(bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method draws the designated bitmap to canvas.`fun drawBitmap(byteArray: `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method draws the designated byte array of bitmap to canvas. |
| [getBitmap](get-bitmap.md) | `fun getBitmap(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)<br>This method gets current canvas as bitmap. |
| [getBitmapAsByteArray](get-bitmap-as-byte-array.md) | `fun getBitmapAsByteArray(format: `[`CompressFormat`](https://developer.android.com/reference/android/graphics/Bitmap/CompressFormat.html)`, quality: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>This method gets the bitmap as byte array. |
| [getScaleBitmap](get-scale-bitmap.md) | `fun getScaleBitmap(w: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, h: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)<br>This method gets current canvas as scaled bitmap. |
| [onDraw](on-draw.md) | `fun onDraw(canvas: `[`Canvas`](https://developer.android.com/reference/android/graphics/Canvas.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method updates the instance of Canvas (View) |
| [onTouchEvent](on-touch-event.md) | `fun onTouchEvent(event: `[`MotionEvent`](https://developer.android.com/reference/android/view/MotionEvent.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method set event listener for drawing. |
| [redo](redo.md) | `fun redo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method draws canvas again for Redo. |
| [undo](undo.md) | `fun undo(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>This method draws canvas again for Undo. |

### Companion Object Functions

| [getBitmapAsByteArray](get-bitmap-as-byte-array.md) | `fun getBitmapAsByteArray(bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, format: `[`CompressFormat`](https://developer.android.com/reference/android/graphics/Bitmap/CompressFormat.html)`, quality: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ByteArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-byte-array/index.html)<br>This static method gets the designated bitmap as byte array. |

### Extension Functions

| [bindView](../android.view.-view/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`View`](https://developer.android.com/reference/android/view/View.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ViewBinder`](../-view-binder/index.md)`<T>` |

