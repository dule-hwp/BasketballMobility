[app](../index.md) / [hwp.basketball.mobility.entitiy.user](.)

## Package hwp.basketball.mobility.entitiy.user

User/coach implemetation of repository pattern with FireBase specific implementation, and view model.

### Types

| Name | Summary |
|---|---|
| [CoachViewModel](-coach-view-model/index.md) | `data class CoachViewModel`<br>Coach view model used for displaying coach info. |
| [UserDataStore](-user-data-store/index.md) | `interface UserDataStore<T>`<br>Created by dusan_cvetkovic on 3/26/17. |
| [UserFirebaseDataStore](-user-firebase-data-store/index.md) | `class UserFirebaseDataStore : `[`UserDataStore`](-user-data-store/index.md)`<`[`CoachViewModel`](-coach-view-model/index.md)`>`<br>Created by dusan_cvetkovic on 3/26/17. |
| [UserRealmModel](-user-realm-model/index.md) | `open class UserRealmModel`<br>Created by dusan_cvetkovic on 3/26/17. |
| [UserRealmUserDataStore](-user-realm-user-data-store/index.md) | `class UserRealmUserDataStore : `[`UserDataStore`](-user-data-store/index.md)`<`[`CoachViewModel`](-coach-view-model/index.md)`>`<br>Created by dusan_cvetkovic on 3/26/17. |
