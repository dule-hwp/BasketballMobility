package hwp.basketball.mobility.entitiy.drills.outcomes

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import org.joda.time.DateTime

/**
 * Created by dusan_cvetkovic on 6/24/17.
 */
data class DrillOutcome(var id: String = "unknown_id",
                        var playerName: String = "",
                        var coachEmail: String? = "",
                        var drillName: String = "",
                        var score: Float = 0F,
                        var drillOutcomeImage: String? = null,
                        var drillOutcomeImageArea: String? = null,
                        var date: String = DateTime.now().toString(),
                        var pathLength: Float = 0F) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<DrillOutcome> = object : Parcelable.Creator<DrillOutcome> {
            override fun createFromParcel(source: Parcel): DrillOutcome = DrillOutcome(source)
            override fun newArray(size: Int): Array<DrillOutcome?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readFloat(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readFloat()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(playerName)
        dest.writeString(coachEmail)
        dest.writeString(drillName)
        dest.writeFloat(score)
        dest.writeString(drillOutcomeImage)
        dest.writeString(drillOutcomeImageArea)
        dest.writeString(date)
        dest.writeFloat(pathLength)
    }
}

data class DrillTempOutcome(val progress: Int,
                            val area: Int?,
                            val drillPreformedBitmap: Bitmap?,
                            val drillPerformedMarked: Bitmap?)