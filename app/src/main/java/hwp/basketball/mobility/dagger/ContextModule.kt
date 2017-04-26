package hwp.basketball.mobility.dagger

import android.content.Context

import dagger.Module
import dagger.Provides

/**
 * Created by dusan_cvetkovic on 3/31/17.
 */
@Module
class ContextModule(private val context: Context) {

    @Provides
    fun context(): Context {
        return context
    }
}
