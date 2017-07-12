# Module app

In each od the leaf (bottom) level packages of the app module we tried to apply MVP android architecture in conjunction with Repository pattern. [Applying Clean Architecture on Android](http://five.agency/android-architecture-part-3-applying-clean-architecture-android/)

# Package hwp.basketball.mobility

This package contains class that extends main application class. Also contains small activities that doesn require applying MVP being to simple.

# Package hwp.basketball.mobility.account.login

MVP implementation fo Login with hiding google sign in behind interface for ease of change and testability.

# Package hwp.basketball.mobility.account.create

This package is in charge of registering coach, but it is simple enough so no need to use MVP.

# Package hwp.basketball.mobility.device.sensor

All of the sensors supported by the application should be inside this package and have their own sub packege. In this packege root we can find BaseSensor that each of the sensors need to implement and we have sensor factory (factory pattern) to build specific sensor implementation based on type.

# Package hwp.basketball.mobility.device.sensor.android

Android implementation of the Base Sensor.

# Package hwp.basketball.mobility.device.sensor.sensortile

SensorTile implementation of the BaseSensor.

# Package hwp.basketball.mobility.device.sensor.test

Test sensor implementation of the BaseSensor.

# Package hwp.basketball.mobility.device.sensor.wicedsense

Wicedsense sensor implementation of the BaseSensor.

# Package hwp.basketball.mobility.drill.create

MVP implementation of create drill activity.

# Package hwp.basketball.mobility.drill.display

MVP implementation fo display drills acttivity.

# Package hwp.basketball.mobility.drillpreparation

Drill preparation is using stepper activity. I wanted to use 3rd party library and make this process look nice so i used [Android  Material Stepper](https://github.com/stepstone-tech/android-material-stepper) and applied the general application theme to it.

# Package hwp.basketball.mobility.drillpreparation.step

Each of the 4 steps in this process contains MVP implementation. If we need to remove or add steps it would be very easy to go to main activity and simple add or remove one fragment. MVP implementation of the step fragments can be found in sub packages. 

# Package hwp.basketball.mobility.drillpreparation.step.connectplayers

MVP pattern fragment implementation of the connect players step.

# Package hwp.basketball.mobility.drillpreparation.step.review

MVP pattern fragment implementation of the review step.

# Package hwp.basketball.mobility.drillpreparation.step.selectdrill

MVP fragment implementation of the select step. In this step it is also possible to create/delete drill, so thats why it makses sense to introduce MVP pattern. 

# Package hwp.basketball.mobility.drillpreparation.step.selectplayers

MVP fragment implementation of the select player. In this step it is also possible to create/edit/delete player, so thats why it makses sense to introduce MVP pattern. 

# Package hwp.basketball.mobility.entitiy

All of the entity subpackages are basically implementation of the repository pattern. The main idea is to hide each of the specific implementations behind repository interface. Each of the sub-packages contains general datastore interface named [EntityName]DataStore, view model for the entity and FireBase implementatio of the general interface.

# Package hwp.basketball.mobility.entitiy.drills

Drills implemetation of repository pattern with FireBase specific implementation, and view model.

# Package hwp.basketball.mobility.entitiy.drills.outcomes

Outcomes implemetation of repository pattern with FireBase specific implementation, and view model.

# Package hwp.basketball.mobility.entitiy.player

Player implemetation of repository pattern with FireBase specific implementation, and view model.

# Package hwp.basketball.mobility.entitiy.user

User/coach implemetation of repository pattern with FireBase specific implementation, and view model.

# Package hwp.basketball.mobility.login

Login implementation. Currently we have to login methods on firebase server, via regular email and via google sign in. Google sign/login implementation is hidden behind interface so it can be testaable, and so that in the future could be potentially replaced with some other, maybe custom made login server. 

# Package hwp.basketball.mobility.drill.perform

MVP implementation fo the perform drill activity. We have presenter talking to both custom SensorDrawing view and activity view.

# Package hwp.basketball.mobility.drill.perform.sketchview

Classes in charge of drawing the paths on the canvas are in this package. It is MVP implementation where we have presenter talking to custom SensorDrawingView, PathRecorderActivity and also to outcome repository interface. This is perfect example of the clean code architecture. 

Presenter communicates with various different parts of the app and delegating results and events. 
Path recording activity implemnts view from the PathRecordingContract to be able to display view related events. It also informs presenter about button events. 


# Package hwp.basketball.mobility.device.sensor.sensortile.sensortilescan

Implementation of scan activity using SensorTile SDK.

# Package hwp.basketball.mobility.util

All of the various utility files are stored in this package. Probably the most interesting one is Extensions.kt file where all of the kotlin extension methods are defined.

# Package hwp.basketball.mobility.view

Package reserved for custom views.

# Package hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker	

WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk). 

# Package hwp.basketball.mobility.device.sensor.wicedsense.util	

WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk).

# Package hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota	

WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk).

# Package hwp.basketball.mobility.device.sensor.wicedsense.ws_bs

WICED Sense "SDK". This should be in separate module, or imported as library (cypress should do better job in providing sdk).