[app](../../../index.md) / [hwp.basketball.mobility.login](../../index.md) / [LoginContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter`

### Functions

| Name | Summary |
|---|---|
| [detach](detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleGoogleSignInResult](handle-google-sign-in-result.md) | `abstract fun handleGoogleSignInResult(result: `[`SignInResultWrapper`](../../../hwp.basketball.mobility.login.google.signin/-sign-in-result-wrapper/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loadBMUser](load-b-m-user.md) | `abstract fun loadBMUser(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [loginWithUserPass](login-with-user-pass.md) | `abstract fun loginWithUserPass(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, password: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LoginPresenter](../../-login-presenter/index.md) | `class LoginPresenter : Presenter, `[`Callback`](../-interactor/-callback/index.md)`, `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
