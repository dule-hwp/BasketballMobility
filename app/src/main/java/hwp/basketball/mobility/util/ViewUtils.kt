package hwp.basketball.mobility.util

import android.content.res.Resources


/**
 *
 * Created by dusan_cvetkovic on 5/8/17.
 */
class ViewUtils {
    companion object {
        val deviceSize: Pair<Int, Int> by lazy {
            val displayMetrics = Resources.getSystem().displayMetrics
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            Pair(height, width)
        }

        fun convertMetersToPixels(strideLengthInMeters: Float): Float {
            return (strideLengthInMeters / 15.0f) * deviceSize.second
        }

        var isInDebugMode: Boolean = false

    }
}