[app](../../../../index.md) / [hwp.basketball.mobility.account.login](../../../index.md) / [LoginContract](../../index.md) / [Interactor](../index.md) / [Callback](.)

# Callback

`interface Callback`

### Functions

| Name | Summary |
|---|---|
| [logInFail](log-in-fail.md) | `abstract fun logInFail(error: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [logInSuccess](log-in-success.md) | `abstract fun logInSuccess(email: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [LoginPresenter](../../../-login-presenter/index.md) | `class LoginPresenter : `[`Presenter`](../../-presenter/index.md)`, Callback, `[`BasePresenter`](../../../../hwp.basketball.mobility/-base-presenter/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
