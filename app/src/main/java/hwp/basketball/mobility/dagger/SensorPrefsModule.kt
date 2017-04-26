package hwp.basketball.mobility.dagger

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

/**
 * Created by dusan_cvetkovic on 3/31/17.
 */

@Module(includes = arrayOf(ContextModule::class))
class SensorPrefsModule {
    val sensorPrefs: String = "SensorCalibrationPrefs"
    @Provides
    fun sensorPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(sensorPrefs, Context.MODE_PRIVATE)
    }
}