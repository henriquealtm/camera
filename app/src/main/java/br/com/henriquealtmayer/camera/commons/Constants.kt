package br.com.henriquealtmayer.camera.commons

import android.util.SparseIntArray
import android.view.Surface

// Permissions
const val requestCameraPermission = 200
const val requestWriteInternalStoragePermission = 201

// JPEG Orientations
val jpegOrientations = SparseIntArray().apply {
    append(Surface.ROTATION_0, 90)
    append(Surface.ROTATION_90, 0)
    append(Surface.ROTATION_180, 270)
    append(Surface.ROTATION_270, 180)
}


