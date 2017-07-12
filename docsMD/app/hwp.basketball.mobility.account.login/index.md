[app](../index.md) / [hwp.basketball.mobility.account.login](.)

## Package hwp.basketball.mobility.account.login

MVP implementation fo Login with hiding google sign in behind interface for ease of change and testability.

### Types

| Name | Summary |
|---|---|
| [GoogleLoginInteractor](-google-login-interactor/index.md) | `open class GoogleLoginInteractor : `[`Interactor`](-login-contract/-interactor/index.md)<br>Created by dusan_cvetkovic on 3/24/17. |
| [LoginActivity](-login-activity/index.md) | `class LoginActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, OnConnectionFailedListener, `[`View`](-login-contract/-view/index.md) |
| [LoginContract](-login-contract/index.md) | `interface LoginContract`<br>This onterface defines login contract. Presenter implementation is in charge of getting the data and dealing with events View implementation is in charge of simply passing the events to presenter and displaying data Interactor implementation handles sign in result and in forms Created by dusan_cvetkovic on 3/23/17. |
| [LoginPresenter](-login-presenter/index.md) | `class LoginPresenter : `[`Presenter`](-login-contract/-presenter/index.md)`, `[`Callback`](-login-contract/-interactor/-callback/index.md)`, `[`BasePresenter`](../hwp.basketball.mobility/-base-presenter/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
