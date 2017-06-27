package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.os.Environment
import java.io.File
import java.io.FileOutputStream
import android.graphics.BitmapFactory
import com.google.firebase.storage.StorageReference
import io.reactivex.Single
import io.reactivex.SingleEmitter
import timber.log.Timber
import java.io.ByteArrayOutputStream


object FirebaseStorageUtils {
    fun saveBitmapToStorage(bitmap: Bitmap, storageReference: StorageReference): Single<String> {
        return Single.create { emitter: SingleEmitter<String> ->
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos)
            val bitmapData = bos.toByteArray()
            val uploadTask = storageReference.putBytes(bitmapData)
            uploadTask
                    .addOnFailureListener {
                        Timber.e("$it")
                        emitter.onError(it)
                    }
                    .addOnSuccessListener {
                        emitter.onSuccess(it.downloadUrl.toString())
                    }
        }
    }

}
