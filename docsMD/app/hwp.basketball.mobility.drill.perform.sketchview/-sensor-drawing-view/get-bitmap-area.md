[app](../../index.md) / [hwp.basketball.mobility.drill.perform.sketchview](../index.md) / [SensorDrawingView](index.md) / [getBitmapArea](.)

# getBitmapArea

`fun getBitmapArea(): `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)

Overrides [View.getBitmapArea](../-sensor-drawing-view-view-contract/-view/get-bitmap-area.md)

Method for exporting area bitmap.
This method is crucial for generating area bitmap which is used to calculate
quality of the drill based on the area generated.

Area should be as small as possible for the outcome to be better.

**Return**
current errorArea bitmap marked in red.

