package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Matrix

object Vector2D {

    private fun dotProduct(vec1: FloatArray, vec2: FloatArray): Float {
        return vec1[0] * vec2[0] + vec1[1] * vec2[1]
    }

    fun angleBetweenTwoVectors(vec1: FloatArray, vec2: FloatArray): Int {
        val angle = Math.acos((dotProduct(vec1, vec2) / (Length(vec1) * Length(vec2))).toDouble())
        return Math.toDegrees(angle).toInt()
    }

    fun angleBetweenTwoVectors(vec1: Array<Float>, vec2: Array<Float>): Int {
        val v1 = floatArrayOf(vec1[0], vec1[1])
        val v2 = floatArrayOf(vec2[0], vec2[1])

        return angleBetweenTwoVectors(v1, v2)
    }

    fun Length(vec: FloatArray): Float {
        return Math.sqrt(Math.pow(vec[0].toDouble(), 2.0) + Math.pow(vec[1].toDouble(), 2.0)).toFloat()
    }

    fun Normalize(vec: FloatArray): FloatArray {
        val length = Length(vec)
        return floatArrayOf(vec[0] / length, vec[1] / length)
    }

    fun Add(vec1: FloatArray, vec2: FloatArray): FloatArray {
        return floatArrayOf(vec1[0] + vec2[0], vec1[1] + vec2[1])
    }

    fun Add(vec1: Array<Float>, vec2: Array<Float>): Array<Float> {
        return arrayOf(vec1[0] + vec2[0], vec1[1] + vec2[1])
    }

    fun MultiplyScalar(vec: FloatArray, scalar: Float): FloatArray {
        return floatArrayOf(vec[0] * scalar, vec[1] * scalar)
    }

    fun Subtract(vec1: FloatArray, vec2: FloatArray): FloatArray {
        return floatArrayOf(vec1[0] - vec2[0], vec1[1] - vec2[1])
    }

    fun Subtract(vec1: Array<Float>, vec2: Array<Float>): Array<Float> {
        return arrayOf(vec1[0] - vec2[0], vec1[1] - vec2[1])
    }

    fun Clamp(value: Float, min: Float, max: Float): Float {

        if (value < min)
            return min
        else if (value > max)
            return max
        else
            return value
    }

    fun Clamp(value: Int, min: Int, max: Int): Int {

        if (value < min)
            return min
        else if (value > max)
            return max
        else
            return value
    }

    fun RotateVector(vec: FloatArray, degrees: Int): FloatArray {
        val rotated = FloatArray(2)
        val rad = Math.toRadians(degrees.toDouble())

        rotated[0] = vec[0] * Math.cos(rad).toFloat() - vec[1] * Math.sin(rad).toFloat()
        rotated[1] = vec[0] * Math.sin(rad).toFloat() + vec[1] * Math.cos(rad).toFloat()

        return rotated
    }

    fun RotateBitmap(source: Bitmap, angle: Float): Bitmap {
        val matrix = Matrix()
        matrix.postRotate(angle)
        return Bitmap.createBitmap(source, 0, 0, source.width, source.height, matrix, true)
    }

    fun getDrawPoint(unitVector: FloatArray, degrees: Int, lineLength: Float, lineStartCoords: FloatArray): FloatArray {
        val rotated = Vector2D.RotateVector(unitVector, degrees)
        val normalizedVec = Vector2D.Normalize(rotated)
        val scaledVec = Vector2D.MultiplyScalar(normalizedVec, lineLength)
        val drawVector = Vector2D.Add(scaledVec, lineStartCoords)
        return drawVector
    }

}
