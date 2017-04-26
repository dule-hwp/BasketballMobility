package hwp.basketball.mobility.pathrecorder.sketchview

import hwp.basketball.mobility.util.Vector2D
import java.util.*

class Movement {

    private var lastDegreesToNorthPole: Int = -1000
    private var oldDegreesToNorthForCompass: Int = -1000
    private var lastAccelerationData: FloatArray = floatArrayOf()
    private var lastGyroAngle: Float = 0.0f

    fun onSensorDataUpdate(data:Triple<Float, FloatArray, Float>) {
//        if (calibrationRangeValues != null) {
        var degreesToNorth = data.first.toInt()
        lastDegreesToNorthPole = degreesToNorth
        lastGyroAngle = data.third
        lastAccelerationData = data.second.copyOf()
        val degreesChange = Math.abs(degreesToNorth - oldDegreesToNorthForCompass).toFloat()
        degreesToNorth = if (degreesChange >= DEGREES_TO_NORTH_EPSILON) degreesToNorth else oldDegreesToNorthForCompass
        oldDegreesToNorthForCompass = degreesToNorth
//            callback.setDegreesToNorth(degreesToNorth)
//        }
    }

    private var moves: LinkedList<Move>? = null
    var isMovement: Boolean = false
        private set
    var isMapRotatedAccordingToCompass: Boolean = false

    private val MIN_DURATION_FOR_MOVE_IN_MILLISECONDS: Long = 100
    private val DISCREET_CHANGE = 10
    internal val DEGREES_TO_NORTH_EPSILON = DISCREET_CHANGE / 2

    //    private var lastDirection: Int = 0
    private var lastTimeInMilliSec: Long = 0
    //    private var oldDegreesToNorth: Int = 0
    private var oldDegreesToNorthForMapRotate: Int = 0

    private var messages: Array<String>? = null

    private var pixels_for_1_milliSecond: Float = 0.toFloat()
    private val SCALE_LOWER_BOUND = 0.0005f
    private val SCALE_UPPER_BOUND = SCALE_LOWER_BOUND * 100.0f

    private val movementStats: MovementStatistics
    var isMovementStatisticsNeeded: Boolean = false

    init {
        this.isMovementStatisticsNeeded = false
        this.movementStats = MovementStatistics()
        this.isMovement = false
        this.isMapRotatedAccordingToCompass = false
        this.messages = arrayOf("line1", "line2")
        this.moves = null
        this.pixels_for_1_milliSecond = SCALE_LOWER_BOUND + (SCALE_UPPER_BOUND - SCALE_LOWER_BOUND) / 2
    }

    fun getMessage(first: Boolean): String {
        return messages!![if (first) 0 else 1]
    }

    fun setPixels_for_1_second(increaseScale: Boolean) {
        val SCALE_CHANGE = 4.0f * SCALE_LOWER_BOUND
        val sign = if (increaseScale) +1.0f else -1.0f
        this.pixels_for_1_milliSecond += SCALE_CHANGE * sign
        this.pixels_for_1_milliSecond = Vector2D.Clamp(this.pixels_for_1_milliSecond, SCALE_LOWER_BOUND, SCALE_UPPER_BOUND)
        messages = arrayOf("Info:", String.format("%d millisecs for 1 pixel", 1 + (1.0f / pixels_for_1_milliSecond).toInt()))
    }

    fun StartMovement() {
//        this.oldDegreesToNorth = -1000
        this.oldDegreesToNorthForMapRotate = -1000
        this.moves = LinkedList<Move>()
        isMovement = true
    }

    fun movementWasStarted(): Boolean {
        return this.moves != null
    }

    fun StopMovement() {
        isMovement = false
    }

//    fun ResetMovement() {
//        isMovement = false
//        moves = null
//    }

    fun ResumeMovement() {
        isMovement = true
        val timeInMilliSec = System.currentTimeMillis()
        lastTimeInMilliSec = timeInMilliSec
    }

//    private val discreetAngle: Int
//        get() {
//            val degrees = averagedDirectionWithEpsilon
//            val sign = if (degrees >= 0) +1 else -1
//            val degreesMagnitude = Math.abs(degrees.toFloat() / DISCREET_CHANGE.toFloat())
//            val discreetAngle = sign * DISCREET_CHANGE * Math.round(degreesMagnitude)
//            return -discreetAngle
//        }

//    private val averagedDirectionWithEpsilon: Int
//        get() {
//
////            var degreesToNorth = averagedDirection
//            val degreesChange = Math.abs(degreesToNorth - oldDegreesToNorth).toFloat()
//            degreesToNorth = if (degreesChange >= DEGREES_TO_NORTH_EPSILON) degreesToNorth else oldDegreesToNorth
//            oldDegreesToNorth = degreesToNorth
//
//            return degreesToNorth
//        }

//    private // calculating averages of negative & positive angles
//    val averagedDirection: Int
//        get() {
//            val DIRECTION_POINTS = 100
//            val directions = IntArray(DIRECTION_POINTS)
//
//            for (i in directions.indices) {
//                directions[i] = lastDegreesToNorthPole
//                try {
//                    Thread.sleep(1)
//                } catch (e: InterruptedException) {
//                }
//
//            }
//
//            var avgPos = 0
//            var avgNeg = 0
//            var countPos = 0
//            var countNeg = 0
//            for (i in directions.indices) {
//                if (directions[i] >= 0) {
//                    countPos++
//                    avgPos += directions[i]
//                } else {
//                    countNeg++
//                    avgNeg += directions[i]
//                }
//            }
//
//            if (countNeg > 0)
//                avgNeg /= countNeg
//            if (countPos > 0)
//                avgPos /= countPos
//
//            val dir: Int
//
//            if (countNeg == 0)
//                dir = avgPos
//            else if (countPos == 0)
//                dir = avgNeg
//            else {
//                val ANGLE_FROM_AXIS_THRESHOLD = 80
//                if (avgPos <= ANGLE_FROM_AXIS_THRESHOLD)
//                    dir = +0
//                else if (avgPos >= 180 - ANGLE_FROM_AXIS_THRESHOLD)
//                    dir = +180
//                else {
//                    if (countPos > countNeg)
//                        dir = avgPos
//                    else
//                        dir = avgNeg
//                }
//
//            }
//
//            return dir
//
//        }

    fun CheckMovement() {
        if (moves == null || !isMovement)
            return

        val timeInMilliSec = System.currentTimeMillis()
//        val direction = discreetAngle
        val direction = lastDegreesToNorthPole

        if (moves!!.size == 0) {
            moves!!.add(Move(direction, 0, lastAccelerationData))
//            lastDirection = direction
            lastTimeInMilliSec = timeInMilliSec
        } else {
            val timeDelta = timeInMilliSec - lastTimeInMilliSec

            if (timeDelta >= MIN_DURATION_FOR_MOVE_IN_MILLISECONDS) {
                moves?.add(Move(direction, timeDelta, lastAccelerationData))
//                lastDirection = direction
                lastTimeInMilliSec = timeInMilliSec
            }
        }
    }

    private fun convertMovesToPoints(startPoint: FloatArray): LinkedList<Array<Float>> {

        var startVec = floatArrayOf(0.0f, -1.0f)

        // rotate map according to compass if user wants this
        if (this.isMapRotatedAccordingToCompass) {
            var degreesNorth = lastDegreesToNorthPole
            val degreesChange = Math.abs(degreesNorth - oldDegreesToNorthForMapRotate).toFloat()
            degreesNorth = if (degreesChange >= DEGREES_TO_NORTH_EPSILON) degreesNorth else oldDegreesToNorthForMapRotate
            oldDegreesToNorthForMapRotate = degreesNorth

            startVec = Vector2D.RotateVector(startVec, degreesNorth)
            startVec = Vector2D.Normalize(startVec)
        }

        // convert moves to X,Y coordinates
        val points = LinkedList<Array<Float>>()
        points.add(arrayOf(startPoint[0], startPoint[1]))

        var lastPoint = startPoint
        for (i in 1..moves!!.size - 1) {
            val move = moves!![i]
            val drawPoint = Vector2D.getDrawPoint(startVec, move.direction, move.durationInMilliSec * pixels_for_1_milliSecond, lastPoint)
            points.add(arrayOf(drawPoint[0], drawPoint[1]))
            lastPoint = drawPoint
        }

        return points
    }

    private fun getMinMaxCoordsOfPoints(points: LinkedList<Array<Float>>): FloatArray {
        val limits = FloatArray(4)

        val limit = 1e+10.toFloat()
        limits[0] = +limit // min X
        limits[1] = -limit // max X
        limits[2] = +limit // min Y
        limits[3] = -limit // max Y

        for (point in points) {
            if (point[0] < limits[0])
                limits[0] = point[0]
            if (point[0] > limits[1])
                limits[1] = point[0]

            if (point[1] < limits[2])
                limits[2] = point[1]
            if (point[1] > limits[3])
                limits[3] = point[1]
        }

        return limits
    }

    private fun centerPathToScreen(points: LinkedList<Array<Float>>, startPoint: FloatArray, limits: FloatArray) {

        val minX = limits[0]
        val maxX = limits[1]
        val minY = limits[2]
        val maxY = limits[3]

        val planCenter = floatArrayOf(minX + (maxX - minX) / 2.0f, minY + (maxY - minY) / 2.0f)
        val shift = arrayOf(startPoint[0] - planCenter[0], startPoint[1] - planCenter[1])

        // translate coordinates so that plan center would move to canvas center
        for (i in points.indices) {
            val oldPoint = points[i]
            val newPoint = Vector2D.Add(oldPoint, shift)
            points[i] = newPoint
        }

    }

    private fun filterOutLinesWithSmallAngleChange(points: LinkedList<Array<Float>>?): LinkedList<Array<Float>>? {

        if (points == null || points.size < 3)
            return points

        val filteredPoints = LinkedList<Array<Float>>()
        filteredPoints.add(points[0])
        filteredPoints.add(points[1])
        val DEGREES_CHANGE = 20

        for (i in 2..points.size - 1) {
            val lastPoint = filteredPoints[filteredPoints.size - 1]
            val rel1 = Vector2D.Subtract(lastPoint, filteredPoints[filteredPoints.size - 2])
            val rel2 = Vector2D.Subtract(points[i], lastPoint)
            val angleInDegrees = Vector2D.angleBetweenTwoVectors(rel1, rel2)
            if (angleInDegrees >= DEGREES_CHANGE)
                filteredPoints.add(points[i])
            else
                filteredPoints[filteredPoints.size - 1] = points[i]
        }

        return filteredPoints
    }

    fun getMovementDataForDraw(startPoint: FloatArray): MovementData? {

        if (moves == null || moves!!.size < 2 || this.isMovementStatisticsNeeded)
            return null

        this.movementStats.calculateMovementStatistics(moves)

        val points = convertMovesToPoints(startPoint)

        val limits = getMinMaxCoordsOfPoints(points)

        centerPathToScreen(points, startPoint, limits)

        val pointsFiltered = filterOutLinesWithSmallAngleChange(points)

//        val path = convertPointsToPath(pointsFiltered)

        val ret = MovementData(pointsFiltered, this.movementStats.statisticsInfoMessages)

        return ret
    }

    data class MovementData(val points: LinkedList<Array<Float>>?, val statisticsInfoMessages: List<String>)

    internal data class Move(var direction: Int, var durationInMilliSec: Long, var speed: FloatArray)

    internal enum class ANGLE_QUARTER {
        UNDEFINED,
        NORTH_WEST,
        WEST_SOUTH,
        SOUTH_EAST,
        EAST_NORTH
    }

    internal inner class MovementStatistics {
        private var durationToNorth: Long = 0
        private var durationToSouth: Long = 0
        private var durationToEast: Long = 0
        private var durationToWest: Long = 0
        private var rotationsClockWise: Long = 0
        private var rotationsCounterClockWise: Long = 0
        private var moveDurationInMilliSec: Long = 0
        private var rotation: Int = 0
        private var accData: FloatArray = floatArrayOf()

        val statisticsInfoMessages: List<String>
            get() {
//                val totalDuration = durationToNorth + durationToWest + durationToSouth + durationToEast
//                val totalRotations = rotationsClockWise + rotationsCounterClockWise

                val spaces = "    "
                val tripleSpaces = "$spaces$spaces$spaces"
                val infoMessages = mutableListOf<String>()
//                infoMessages.add("Movement statistics :")
//                infoMessages.add("")
//                infoMessages.add(spaces + spaces + "Duration :")
//                infoMessages.add("$tripleSpaces North  : $durationToNorth ms")
//                infoMessages.add("$tripleSpaces West    : $durationToWest ms")
//                infoMessages.add("$tripleSpaces South  : $durationToSouth ms")
//                infoMessages.add("$tripleSpaces East     : $durationToEast ms")
//                infoMessages.add("$tripleSpaces TOTAL : $totalDuration ms")
//                infoMessages.add("")
//                infoMessages.add(spaces + spaces + "Rotations :")
//                infoMessages.add("$tripleSpaces Clockwise         : $rotationsClockWise")
//                infoMessages.add("$tripleSpaces Counter-clockwise : $rotationsCounterClockWise")
//                infoMessages.add("$tripleSpaces TOTAL             : $totalRotations")
//                infoMessages.add("")
                infoMessages.add(spaces + spaces + "Current Sensors generated Info:")
                infoMessages.add("$tripleSpaces Current Rotation     : $rotation")
                infoMessages.add("$tripleSpaces Duration of last move: $moveDurationInMilliSec ms")
                infoMessages.add("$tripleSpaces AccelerationX  : ${accData[0]}")
                infoMessages.add("$tripleSpaces AccelerationY  : ${accData[1]}")
                infoMessages.add("$tripleSpaces AccelerationZ  : ${accData[2]}")
                infoMessages.add("$tripleSpaces GyroAngle: $lastGyroAngle")

                return infoMessages
            }

        private fun getDirectionQuarter(move: Move): ANGLE_QUARTER {
            val startVec = floatArrayOf(0.0f, -1.0f)
            val origin = floatArrayOf(0.0f, 0.0f)

            val vec = Vector2D.getDrawPoint(startVec, move.direction, 1.0f, origin)

            val SIGN_POSITIVE = +1.0f
            val SIGN_NEGATIVE = -1.0f

            val isNorthWest: Boolean
            val isWestSouth: Boolean
            val isSouthEast: Boolean
            val isEastNorth: Boolean

            var xSign = Math.signum(vec[0])
            var ySign = Math.signum(vec[1])
            xSign = if (xSign == 0.0f) SIGN_POSITIVE else xSign
            ySign = if (ySign == 0.0f) SIGN_POSITIVE else ySign

            isNorthWest = ySign == SIGN_NEGATIVE && xSign == SIGN_POSITIVE
            isWestSouth = ySign == SIGN_POSITIVE && xSign == SIGN_POSITIVE
            isSouthEast = ySign == SIGN_POSITIVE && xSign == SIGN_NEGATIVE
            isEastNorth = ySign == SIGN_NEGATIVE && xSign == SIGN_NEGATIVE

            if (isNorthWest)
                return ANGLE_QUARTER.NORTH_WEST

            if (isWestSouth)
                return ANGLE_QUARTER.WEST_SOUTH

            if (isSouthEast)
                return ANGLE_QUARTER.SOUTH_EAST

            if (isEastNorth)
                return ANGLE_QUARTER.EAST_NORTH

            return ANGLE_QUARTER.UNDEFINED
        }

        private fun updateMoveDurationStatistics(moves: LinkedList<Move>, index: Int) {
            val startVec = floatArrayOf(0.0f, -1.0f)
            val origin = floatArrayOf(0.0f, 0.0f)

            val move = moves[index]
            val quarter = getDirectionQuarter(move)
            val vec = Vector2D.getDrawPoint(startVec, move.direction, move.durationInMilliSec.toFloat(), origin)

            durationToNorth += if (quarter == ANGLE_QUARTER.NORTH_WEST || quarter == ANGLE_QUARTER.EAST_NORTH) Math.abs(vec[1]).toLong() else 0
            durationToSouth += if (quarter == ANGLE_QUARTER.WEST_SOUTH || quarter == ANGLE_QUARTER.SOUTH_EAST) Math.abs(vec[1]).toLong() else 0
            durationToWest += if (quarter == ANGLE_QUARTER.NORTH_WEST || quarter == ANGLE_QUARTER.WEST_SOUTH) Math.abs(vec[0]).toLong() else 0
            durationToEast += if (quarter == ANGLE_QUARTER.SOUTH_EAST || quarter == ANGLE_QUARTER.EAST_NORTH) Math.abs(vec[0]).toLong() else 0

            rotation = move.direction
            moveDurationInMilliSec = move.durationInMilliSec
            accData = move.speed
        }

        private fun updateMoveRotationStatistics(moves: LinkedList<Move>, index: Int) {
            if (index == 0)
                return

            val dirCurrent = moves[index].direction + 180
            val dirPrevious = moves[index - 1].direction + 180
            val dirChange = dirCurrent - dirPrevious

            var isClockWise: Boolean? = null

            if (dirChange > 0)
                isClockWise = true
            else if (dirChange < 0)
                isClockWise = false

            if (isClockWise != null) {
                if (isClockWise == true)
                    rotationsClockWise += 1
                else
                    rotationsCounterClockWise += 1
            }

        }

        fun calculateMovementStatistics(moves: LinkedList<Move>?) {

            durationToEast = 0
            durationToNorth = 0
            durationToSouth = 0
            durationToWest = 0
            rotationsClockWise = 0
            rotationsCounterClockWise = 0

            if (moves == null || moves.size == 0)
                return

            for (i in moves.indices) {

                updateMoveDurationStatistics(moves, i)

                updateMoveRotationStatistics(moves, i)


            }
        }
    }
}


