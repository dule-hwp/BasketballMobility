package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import android.graphics.BitmapFactory


object PhoneStorage {

    fun saveBitmap(bitmap: Bitmap?, fileNameShort: String): String? {
        if (bitmap == null)
            return null
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val file = File(path, fileNameShort)
        try {
            val stream = FileOutputStream(file)
            val writeSuccess = bitmap.compress(CompressFormat.PNG, 100, stream)
            if (!writeSuccess)
                return null
            stream.close()
            return fileNameShort
        } catch (e: Exception) {
            return null
        }

    }

    fun getBitmap(fileName: String): Bitmap? {
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val file = File(path, fileName)
        val options = BitmapFactory.Options()
//        options.inSampleSize = 8
        try {
            val decodeFile = BitmapFactory.decodeFile(file.path)
            return decodeFile
        } catch (exeption: Exception) {
            exeption.printStackTrace()
        }
        return null
    }

}
