package hwp.basketball.mobility.entitiy.drills

import android.graphics.Bitmap
import com.rm.freedrawview.Point

/**
 * Created by dusan_cvetkovic on 4/4/17.
 */
data class DrillViewModel(val name: String,
                          val id: Int? = null,
                          val numberOfPlayers: Int,
                          val drillImage: Bitmap?,
                          val pathPoints: ArrayList<Point>?)