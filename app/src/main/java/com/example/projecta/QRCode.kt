package com.example.projecta

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

/*
val qrcode = QRCode(MainActivity) - init
qrcode.scan()                     - scan
qrcode.getSuccess()               - check success
qrcode.getTextResult().value      - result
 */

fun generateQRCode(data: String, width: Int, height: Int): ImageBitmap {
    val matrix: BitMatrix = MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height)
    return BarcodeEncoder().createBitmap(matrix).asImageBitmap()
}
class QRCode(val componentActivity: ComponentActivity) {
    private var textResult = mutableStateOf("")
    private var success = false

    private val barCodeLauncher =
        componentActivity.registerForActivityResult(ScanContract()) { result ->
            if (result.contents == null) {
                Toast.makeText(componentActivity.applicationContext, "Сканирование прервано", Toast.LENGTH_SHORT).show()
                success = false
            } else {
                success = true
                textResult.value = result.contents
            }
        }
    fun getTextResult(): MutableState<String> {
        return textResult
    }

    fun getSuccess(): Boolean {
        return success
    }
    private fun showCamera() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Сканируйте QR код")
        options.setCameraId(0)
        options.setBeepEnabled(false)
        options.setOrientationLocked(false)

        barCodeLauncher.launch(options)
    }

    private val requestPermissionLauncher = componentActivity.registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            showCamera()
        }
    }

    fun scan() {
        if (ContextCompat.checkSelfPermission(
                componentActivity.applicationContext,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showCamera()
        } else if (shouldShowRequestPermissionRationale(
                componentActivity,
                android.Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(componentActivity.applicationContext, "Сканирование прервано", android.widget.Toast.LENGTH_SHORT)
                .show()
            success = false
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }

        if (ContextCompat.checkSelfPermission(
                componentActivity.applicationContext,
                android.Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showCamera()
        } else if (shouldShowRequestPermissionRationale(
                MainActivity(),
                android.Manifest.permission.CAMERA
            )
        ) {
            Toast.makeText(componentActivity.applicationContext, "Сканирование прервано", Toast.LENGTH_SHORT).show()
            success = false
        } else {
            requestPermissionLauncher.launch(android.Manifest.permission.CAMERA)
        }
    }
}