/**
 * This package contains class that extends main application class.
 * */
package hwp.basketball.mobility

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import net.danlew.android.joda.JodaTimeAndroid
//import io.realm.Realm
//import io.realm.Realm.setDefaultConfiguration
//import io.realm.RealmConfiguration
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by dusan_cvetkovic on 3/6/17.
 */
class BasketballMobilityApp : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(object : DebugTree() {
                override fun createStackElementTag(element: StackTraceElement?): String {
                    return super.createStackElementTag(element) + ":" + element?.lineNumber
                }
            })
        } else {
            Timber.plant(CrashReportingTree())
        }

//        initRealm()
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
//when you addDrillToDatabase Crashlytics
//            FakeCrashLibrary.log(priority, tag, message)

            if (t != null) {
                if (priority == Log.ERROR) {
//                    FakeCrashLibrary.logError(t)
                } else if (priority == Log.WARN) {
//                    FakeCrashLibrary.logWarning(t)
                }
            }
        }
    }
}