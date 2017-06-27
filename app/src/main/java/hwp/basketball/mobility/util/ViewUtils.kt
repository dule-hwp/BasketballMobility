package hwp.basketball.mobility.util

import android.content.res.Resources


/**
 *
 * Created by dusan_cvetkovic on 5/8/17.
 */
class ViewUtils {
    companion object {
        fun getDeviceSize(): Pair<Int, Int> {
            val displayMetrics = Resources.getSystem().displayMetrics
            val height = displayMetrics.heightPixels
            val width = displayMetrics.widthPixels
            return Pair(height, width)
        }

        fun convertMetersToPixels(strideLengthInMeters: Float): Float {
            return (strideLengthInMeters / 15.0f) * getDeviceSize().second
        }

        var isInDebugMode: Boolean = false

    }
}