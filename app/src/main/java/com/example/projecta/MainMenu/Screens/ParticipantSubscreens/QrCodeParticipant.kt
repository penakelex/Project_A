package com.example.projecta.MainMenu

import android.content.ClipData
import android.content.Context.CLIPBOARD_SERVICE
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.Background
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.QrCodeImage
import com.example.projecta.R
import com.example.projecta.YourImage

@Composable
fun QrCodeParticipant(BackNavigation: () -> Unit) {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    Background()

    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MaterialImageButton(
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp),
                        painterResource = painterResource(id = R.drawable.back),
                        onClick = BackNavigation
                    )
                    MaterialButton(
                        text = "Обновить", modifier = Modifier
                            .width(220.dp)
                            .height(50.dp)
                    ) {}
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            )
            {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(100.dp)
                ) {
                    YourImage(painterResource = painterResource(id = R.drawable.empty_avatar))
                }
                Spacer(modifier = Modifier.padding(5.dp))
                Box(
                    modifier = Modifier
                        .height(300.dp)
                        .width(300.dp)
                ) {
                    QrCodeImage(painterResource = painterResource(id = R.drawable.qrkod))
                }
                Text(
                    "Покажите QR-код, организатору мероприятия",
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
