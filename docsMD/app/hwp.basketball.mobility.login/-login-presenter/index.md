[app](../../index.md) / [hwp.basketball.mobility.login](../index.md) / [LoginPresenter](.)

# LoginPresenter

`class LoginPresenter : `[`Presenter`](../-login-contract/-presenter/index.md)`, `[`Callback`](../-login-contract/-interactor/-callback/index.md)`, `[`BasePresenter`](../../hwp.basketball.mobility/-base-presenter/index.md)

Created by dusan_cvetkovic on 3/23/17.

### Constructors

| [&lt;init&gt;](-init-.md) | `LoginPresenter(view: `[`View`](../-login-contract/-view/index.md)`, coachDataStore: `[`UserDataStore`](../../hwp.basketball.mobility.entitiy.user/-user-data-store/index.md)`<`[`CoachViewModel`](../../hwp.basketball.mobility.entitiy.user/-coach-view-model/index.md)`>)`<br>Created by dusan_cvetkovic on 3/23/17. |

### Properties

| [coachDataStore](coach-data-store.md) | `val coachDataStore: `[`UserDataStore`](../../hwp.basketball.mobility.entitiy.user/-user-data-store/index.md)`<`[`CoachViewModel`](../../hwp.basketball.mobility.entitiy.user/-coach-view-model/index.md)`>` |

### Functions

| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleGoogleSignInResult](handle-google-sign-in-result.md) | `fun handleGoogleSignInResult(result: `[`SignInResultWrapper`](../../hwp.basketball.mobility.login.google.signin/-sign-in-result-wrapper/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loadBMUser](load-b-m-user.md) | `fun loadBMUser(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logInFail](log-in-fail.md) | `fun logInFail(error: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logInSuccess](log-in-success.md) | `fun logInSuccess(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loginWithUserPass](login-with-user-pass.md) | `fun loginWithUserPass(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

