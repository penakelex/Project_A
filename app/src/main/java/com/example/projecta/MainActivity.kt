package com.example.projecta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

lateinit var activity: ComponentActivity
lateinit var qrcode: QRCode
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this
        qrcode = QRCode(this)
        setContent {
            initNavigationGate()
        }

    }
}
