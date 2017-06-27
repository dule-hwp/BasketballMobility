package hwp.basketball.mobility.pathrecorder.sketchview

import hwp.basketball.mobility.util.PointF
import hwp.basketball.mobility.util.Vector2D

class Movement {

    companion object {
        val startVec = floatArrayOf(0f, -1f)
        fun getNextDrawPoint(lastPoint: PointF, move: Move): PointF {
            return Vector2D.getDrawPoint(startVec, move.direction, move.distance, lastPoint)
        }
    }

    data class Move(var direction: Float, var distance: Float)
}


