package hwp.basketball.mobility

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import hwp.basketball.mobility.dagger.ContextModule
//import hwp.basketball.mobility.dagger.DaggerBasketballMobilityAppComponent
import io.realm.Realm
import io.realm.Realm.setDefaultConfiguration
import io.realm.RealmConfiguration
import timber.log.Timber
import timber.log.Timber.DebugTree


/**
 * Created by dusan_cvetkovic on 3/6/17.
 */
class BasketballMobilityApp : Application() {

//    companion object {
//        lateinit var activity: Context
//    }

    override fun onCreate() {
        super.onCreate()
//        val appComponent = DaggerBasketballMobilityAppComponent.builder()
//                .contextModule(ContextModule(applicationContext))
//                .build()

//        activity = appComponent.getActivity()


        if (BuildConfig.DEBUG) {
            Timber.plant(object : DebugTree() {
                override fun createStackElementTag(element: StackTraceElement?): String {
                    return super.createStackElementTag(element) + ":" + element?.lineNumber
                }
            })
        } else {
            Timber.plant(CrashReportingTree())
        }

        initRealm()

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build())
    }

    private fun initRealm() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
//                .name("basketballMobility.realm")
                .build()
        setDefaultConfiguration(config)
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
//when you add Crashlytics
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