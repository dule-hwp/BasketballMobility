package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.os.Environment
import java.io.File
import java.io.FileOutputStream

object Storage {

    fun saveBitmap(bitmap: Bitmap?): String? {
        if (bitmap==null)
            return null
        val fileNameShort = "path_${System.currentTimeMillis() / 1000}.jpg"
        val path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val file = File(path, fileNameShort)

        try {
            val stream = FileOutputStream(file)
            val writeSuccess = bitmap.compress(CompressFormat.JPEG, 100, stream)
            if (!writeSuccess)
                return null
            stream.close()
            return fileNameShort
        } catch (e: Exception) {
            return null
        }

    }

}
