[app](../index.md) / [hwp.basketball.mobility.drill.perform.sketchview](.)

## Package hwp.basketball.mobility.drill.perform.sketchview

Classes in charge of drawing the paths on the canvas are in this package. It is MVP implementation where we have presenter talking to custom SensorDrawingView, PathRecorderActivity and also to outcome repository interface. This is perfect example of the clean code architecture.

Presenter communicates with various different parts of the app and delegating results and events. 
Path recording activity implemnts view from the PathRecordingContract to be able to display view related events. It also informs presenter about button events.

### Types

| Name | Summary |
|---|---|
| [SensorDrawingView](-sensor-drawing-view/index.md) | `class SensorDrawingView : `[`View`](https://developer.android.com/reference/android/view/View.html)`, `[`View`](-sensor-drawing-view-view-contract/-view/index.md)<br>Custom view made for the purpose of drawing sensor generated path on top of basketball field bitmap. |
| [SensorDrawingViewPresenter](-sensor-drawing-view-presenter/index.md) | `class SensorDrawingViewPresenter : `[`Presenter`](-sensor-drawing-view-view-contract/-presenter/index.md)<br>Created by dusan_cvetkovic on 3/7/17. |
| [SensorDrawingViewViewContract](-sensor-drawing-view-view-contract/index.md) | `interface SensorDrawingViewViewContract`<br>Created by dusan_cvetkovic on 3/7/17. |
