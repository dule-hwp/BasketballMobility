[app](.)

In each od the leaf (bottom) level packages of the app module we tried to apply MVP android architecture in conjunction with Repository pattern. [Applying Clean Architecture on Android](http://five.agency/android-architecture-part-3-applying-clean-architecture-android/)

### Packages

| Name | Summary |
|---|---|
| [hwp.basketball.mobility](hwp.basketball.mobility/index.md) | This package contains class that extends main application class. Also contains small activities that doesn require applying MVP being to simple. |
| [hwp.basketball.mobility.account.create](hwp.basketball.mobility.account.create/index.md) | This package is in charge of registering coach, but it is simple enough so no need to use MVP. |
| [hwp.basketball.mobility.account.login](hwp.basketball.mobility.account.login/index.md) | MVP implementation fo Login with hiding google sign in behind interface for ease of change and testability. |
| [hwp.basketball.mobility.account.login.google.signin](hwp.basketball.mobility.account.login.google.signin/index.md) |  |
| [hwp.basketball.mobility.device.sensor](hwp.basketball.mobility.device.sensor/index.md) | All of the sensors supported by the application should be inside this package and have their own sub packege. In this packege root we can find BaseSensor that each of the sensors need to implement and we have sensor factory (factory pattern) to build specific sensor implementation based on type. |
| [hwp.basketball.mobility.device.sensor.android](hwp.basketball.mobility.device.sensor.android/index.md) | Android implementation of the Base Sensor. |
| [hwp.basketball.mobility.device.sensor.sensortile](hwp.basketball.mobility.device.sensor.sensortile/index.md) | SensorTile implementation of the BaseSensor. |
| [hwp.basketball.mobility.device.sensor.sensortile.sensortilescan](hwp.basketball.mobility.device.sensor.sensortile.sensortilescan/index.md) | Implementation of scan activity using SensorTile SDK. |
| [hwp.basketball.mobility.device.sensor.test](hwp.basketball.mobility.device.sensor.test/index.md) | Test sensor implementation of the BaseSensor. |
| [hwp.basketball.mobility.device.sensor.wicedsense](hwp.basketball.mobility.device.sensor.wicedsense/index.md) | Wicedsense sensor implementation of the BaseSensor. |
| [hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker](hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker/index.md) | WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk).  |
| [hwp.basketball.mobility.device.sensor.wicedsense.util](hwp.basketball.mobility.device.sensor.wicedsense.util/index.md) | WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk). |
| [hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota](hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota/index.md) | WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk). |
| [hwp.basketball.mobility.device.sensor.wicedsense.ws_bs](hwp.basketball.mobility.device.sensor.wicedsense.ws_bs/index.md) | WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk). |
| [hwp.basketball.mobility.drill.create](hwp.basketball.mobility.drill.create/index.md) | MVP implementation of create drill activity. |
| [hwp.basketball.mobility.drill.display](hwp.basketball.mobility.drill.display/index.md) | MVP implementation fo display drills acttivity. |
| [hwp.basketball.mobility.drill.display.dummy](hwp.basketball.mobility.drill.display.dummy/index.md) |  |
| [hwp.basketball.mobility.drill.perform](hwp.basketball.mobility.drill.perform/index.md) | MVP implementation fo the perform drill activity. We have presenter talking to both custom SensorDrawing view and activity view. |
| [hwp.basketball.mobility.drill.perform.sketchview](hwp.basketball.mobility.drill.perform.sketchview/index.md) | Classes in charge of drawing the paths on the canvas are in this package. It is MVP implementation where we have presenter talking to custom SensorDrawingView, PathRecorderActivity and also to outcome repository interface. This is perfect example of the clean code architecture.  |
| [hwp.basketball.mobility.drillpreparation](hwp.basketball.mobility.drillpreparation/index.md) | Drill preparation is using stepper activity. I wanted to use 3rd party library and make this process look nice so i used [Android  Material Stepper](https://github.com/stepstone-tech/android-material-stepper) and applied the general application theme to it. |
| [hwp.basketball.mobility.drillpreparation.step](hwp.basketball.mobility.drillpreparation.step/index.md) | Each of the 4 steps in this process contains MVP implementation. If we need to remove or add steps it would be very easy to go to main activity and simple add or remove one fragment. MVP implementation of the step fragments can be found in sub packages.  |
| [hwp.basketball.mobility.drillpreparation.step.connectplayers](hwp.basketball.mobility.drillpreparation.step.connectplayers/index.md) | MVP pattern fragment implementation of the connect players step. |
| [hwp.basketball.mobility.drillpreparation.step.review](hwp.basketball.mobility.drillpreparation.step.review/index.md) | MVP pattern fragment implementation of the review step. |
| [hwp.basketball.mobility.drillpreparation.step.selectdrill](hwp.basketball.mobility.drillpreparation.step.selectdrill/index.md) | MVP fragment implementation of the select step. In this step it is also possible to create/delete drill, so thats why it makses sense to introduce MVP pattern.  |
| [hwp.basketball.mobility.drillpreparation.step.selectplayers](hwp.basketball.mobility.drillpreparation.step.selectplayers/index.md) | MVP fragment implementation of the select player. In this step it is also possible to create/edit/delete player, so thats why it makses sense to introduce MVP pattern.  |
| [hwp.basketball.mobility.entitiy.drills](hwp.basketball.mobility.entitiy.drills/index.md) | Drills implemetation of repository pattern with FireBase specific implementation, and view model. |
| [hwp.basketball.mobility.entitiy.drills.outcomes](hwp.basketball.mobility.entitiy.drills.outcomes/index.md) | Outcomes implemetation of repository pattern with FireBase specific implementation, and view model. |
| [hwp.basketball.mobility.entitiy.player](hwp.basketball.mobility.entitiy.player/index.md) | Player implemetation of repository pattern with FireBase specific implementation, and view model. |
| [hwp.basketball.mobility.entitiy.user](hwp.basketball.mobility.entitiy.user/index.md) | User/coach implemetation of repository pattern with FireBase specific implementation, and view model. |
| [hwp.basketball.mobility.util](hwp.basketball.mobility.util/index.md) | All of the various utility files are stored in this package. Probably the most interesting one is Extensions.kt file where all of the kotlin extension methods are defined. |
| [hwp.basketball.mobility.view](hwp.basketball.mobility.view/index.md) | Package reserved for custom views. |

### Index

[All Types](alltypes/index.md)