[app](../../index.md) / [hwp.basketball.mobility.entitiy.user](../index.md) / [UserDataStore](.)

# UserDataStore

`interface UserDataStore<T>`

Created by dusan_cvetkovic on 3/26/17.

### Functions

| Name | Summary |
|---|---|
| [add](add.md) | `abstract fun add(item: T): Completable` |
| [findByEmail](find-by-email.md) | `abstract fun findByEmail(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`CoachViewModel`](../-coach-view-model/index.md)`>?` |

### Inheritors

| Name | Summary |
|---|---|
| [UserRealmUserDataStore](../-user-realm-user-data-store/index.md) | `class UserRealmUserDataStore : UserDataStore<`[`CoachViewModel`](../-coach-view-model/index.md)`>`<br>Created by dusan_cvetkovic on 3/26/17. |
