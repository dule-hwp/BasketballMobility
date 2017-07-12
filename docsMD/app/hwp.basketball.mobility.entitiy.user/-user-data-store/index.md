[app](../../index.md) / [hwp.basketball.mobility.entitiy.user](../index.md) / [UserDataStore](.)

# UserDataStore

`interface UserDataStore<T>`

Created by dusan_cvetkovic on 3/26/17.

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `abstract fun add(coach: T): Completable` |
| [findByEmail](find-by-email.md) | `abstract fun findByEmail(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Maybe<`[`CoachViewModel`](../-coach-view-model/index.md)`>` |

### Inheritors

| Name | Summary |
|---|---|
| [UserFirebaseDataStore](../-user-firebase-data-store/index.md) | `class UserFirebaseDataStore : UserDataStore<`[`CoachViewModel`](../-coach-view-model/index.md)`>`<br>Created by dusan_cvetkovic on 3/26/17. |
| [UserRealmUserDataStore](../-user-realm-user-data-store/index.md) | `class UserRealmUserDataStore : UserDataStore<`[`CoachViewModel`](../-coach-view-model/index.md)`>`<br>Created by dusan_cvetkovic on 3/26/17. |
