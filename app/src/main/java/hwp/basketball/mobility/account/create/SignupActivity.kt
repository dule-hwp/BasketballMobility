package hwp.basketball.mobility

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.jakewharton.rxbinding2.widget.RxTextView
import durdinapps.rxfirebase2.RxFirebaseAuth
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.entitiy.user.CoachViewModel
import hwp.basketball.mobility.login.LoginActivity
import hwp.basketball.mobility.util.toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.functions.Function4
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_signup.*
import timber.log.Timber

class SignupActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, SignupActivity::class.java)
        }
    }

    private lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        title = "Sign Up"
        animation_view.setImageAssetsFolder("images")

        link_login.setOnClickListener {
            startActivity(LoginActivity.getStartIntent(this))
            finish()
        }

        btn_signup.setOnClickListener {
            if (!passwordsMatch)
                toast("Passwords don't match!!!")
            else if (!noEmptyFields)
                toast("You must populate all fields!")
            else
                doTheSignUp()
        }

        compositeDisposable = CompositeDisposable()
        registerFormChangeObservers()
    }

    private fun doTheSignUp() {
        //Firebase sign up
        Timber.d("creating user in firebase")
        val email = input_email.text.toString()
        val pass = input_password.text.toString()
        RxFirebaseAuth.createUserWithEmailAndPassword(FirebaseAuth.getInstance(), email, pass)
                .subscribe({ result ->
                    // Write a message to the database
                    val database = FirebaseDatabase.getInstance()
                    if (chkIsCoach.isChecked) {
                        val user = CoachViewModel(input_name.text.toString(), email)
                        database.reference.child("coaches").child(result.user.uid)
                                .setValue(user)
                    }
                    else{
                        val playerViewModel = PlayerViewModel()
                        database.reference.child("players").child(result.user.uid)
                                .setValue(playerViewModel)
                    }
                    startActivity(HomeActivity.getStartIntent(this))
                    finish()
                }, {error->
                    Timber.e(error)
                    toast(error.message+"")
                })
    }

    private var noEmptyFields: Boolean = false
    private var passwordsMatch: Boolean = false

    private fun registerFormChangeObservers() {
        val passwordObservable = RxTextView.textChanges(input_password)
        val confirmPassObservable = RxTextView.textChanges(input_reEnterPassword)
        val nameObservable = RxTextView.textChanges(input_name)
        val emailObservable = RxTextView.textChanges(input_email)
        val disposable = Observable.combineLatest(passwordObservable, confirmPassObservable, Observable.just(""),
                Function3<CharSequence, CharSequence, String, Boolean> { t1, t2, _ ->
                    t1.toString() == t2.toString()
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe({ passwordsMatch ->
                    if (passwordsMatch)
                        input_reEnterPassword.error = null
                    else
                        input_reEnterPassword.error = "Passwords don't match"
                    this.passwordsMatch = passwordsMatch
                })

        val disposable2 = Observable.combineLatest(passwordObservable, confirmPassObservable, nameObservable, emailObservable,
                Function4<CharSequence, CharSequence, CharSequence, CharSequence, Boolean> { t1, t2, name, email ->
                    t1.isNotBlank() && t2.isNotBlank() && name.isNotBlank() && email.isNotBlank()
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ noEmptyFields ->
                    this.noEmptyFields = noEmptyFields
                })

        compositeDisposable.add(disposable)
        compositeDisposable.add(disposable2)


    }

    override fun onStop() {
        super.onStop()
        compositeDisposable.clear()
    }
}
