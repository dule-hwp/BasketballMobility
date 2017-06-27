package hwp.basketball.mobility.entitiy.drills

import android.os.Parcel
import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import hwp.basketball.mobility.util.PointF

/**
 *
 * Created by dusan_cvetkovic on 4/4/17.
 */
data class DrillViewModel(val name: String = "Unknown",
                          var id: String = "Unknown",
                          val numberOfPlayers: Int = 0,
                          var drillImage: String? = null,
                          val pathPoints: List<PercentPoint> = emptyList(),
                          val outcomes: HashMap<String, DrillOutcome> = HashMap<String, DrillOutcome>())
    : Parcelable, ExpandableGroup<DrillOutcome>(name, outcomes.values.toMutableList()) {

    fun populateItems() {
        items.addAll(outcomes.values)
    }

    companion object {
        fun getTestDrill(id: String): DrillViewModel {
            val pathPoints = arrayListOf(PercentPoint(0.3f, 0.7f), PercentPoint(0.7f, 0.2f))
            return DrillViewModel(name = "Drill $id", pathPoints = pathPoints,
                    drillImage = null, id = id, numberOfPlayers = 1)
        }

        fun getComplexTestDrill(id: String): DrillViewModel {
            val pathPoints = arrayListOf(PercentPoint(0.3f, 0.7f), PercentPoint(0.7f, 0.2f),
                    PercentPoint(0.7f, 0.6f))
            return DrillViewModel(name = "Drill $id", pathPoints = pathPoints,
                    drillImage = null, id = id, numberOfPlayers = 1)
        }

        @JvmField val CREATOR: Parcelable.Creator<DrillViewModel> = object : Parcelable.Creator<DrillViewModel> {
            override fun createFromParcel(source: Parcel): DrillViewModel = DrillViewModel(source)
            override fun newArray(size: Int): Array<DrillViewModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            ArrayList<PercentPoint>().apply { source.readList(this, PercentPoint::class.java.classLoader) },
            source.readSerializable() as HashMap<String, DrillOutcome>
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeString(id)
        dest.writeInt(numberOfPlayers)
        dest.writeString(drillImage)
        dest.writeList(pathPoints)
        dest.writeSerializable(outcomes)
    }
}

/**
 * Used to support different view sizes where path might ne drawn.
 * */
data class PercentPoint(var percentX: Float = 0f,
                        var percentY: Float = 0f) {
    fun toViewPoint(view: ViewDimens): PointF = PointF(percentX * view.width, percentY * view.height)

    companion object {
        fun fromViewPoint(point: PointF, viewDimens: ViewDimens): PercentPoint {
            return PercentPoint(point.x / viewDimens.width, point.y / viewDimens.height)
        }
    }
}

data class ViewDimens(val width: Int, val height: Int)