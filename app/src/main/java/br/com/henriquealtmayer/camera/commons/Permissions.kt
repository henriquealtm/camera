package br.com.henriquealtmayer.camera.commons

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.core.app.ActivityCompat
import br.com.henriquealtmayer.camera.R

// Request Section
fun Activity.requestCameraPermission(
    onPermissionGranted: () -> Unit
) {
    requestPermission(
        permissionName = Manifest.permission.CAMERA,
        permissionCode = REQUEST_CAMERA_PERMISSION,
        onPermissionGranted = onPermissionGranted
    )
}

fun Activity.requestWriteInternalStoragePermission(
    onPermissionGranted: () -> Unit
) {
    requestPermission(
        permissionName = Manifest.permission.WRITE_EXTERNAL_STORAGE,
        permissionCode = REQUEST_WRITE_INTERNAL_STORAGE_PERMISSION,
        onPermissionGranted = onPermissionGranted
    )
}

private fun Activity.requestPermission(
    permissionName: String,
    permissionCode: Int,
    onPermissionGranted: () -> Unit
) {
    if (ActivityCompat.checkSelfPermission(
            this,
            permissionName
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(permissionName),
            permissionCode
        )
        return
    }

    onPermissionGranted.invoke()
}

// Handling Result Section
fun Activity.handleCameraPermissionResult(
    requestCode: Int,
    grantResults: IntArray
) {
    handlePermissionResult(
        REQUEST_CAMERA_PERMISSION,
        requestCode,
        grantResults,
        R.string.camera_permission_not_granted
    )
}

// Handling Result Section
fun Activity.handleWriteInternalStoragePermissionResult(
    requestCode: Int,
    grantResults: IntArray
) {
    handlePermissionResult(
        REQUEST_WRITE_INTERNAL_STORAGE_PERMISSION,
        requestCode,
        grantResults,
        R.string.write_internal_storage_permission_not_granted
    )
}

private fun Activity.handlePermissionResult(
    permissionCode: Int,
    requestCode: Int,
    grantResults: IntArray,
    @StringRes errorMessageId: Int
) {
    if (requestCode == permissionCode) {
        if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            Toast.makeText(this, getString(errorMessageId), Toast.LENGTH_LONG).show()
            finish()
        }
    }
}