package com.example.projecta.MainMenu.Screens.ParticipantSubscreens

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialTextField
import com.example.projecta.QRCode
import com.example.projecta.QrCodeImage
import com.example.projecta.TextComponent
import com.example.projecta.qrcode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinDialog(): MutableState<Boolean> {
    val openDialog = remember { mutableStateOf(false) }
    val code = qrcode.getTextResult()

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false }
        ) {
            Card(
                modifier = Modifier
                    .padding(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text("Способы присоединения", fontSize = 23.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                    MaterialButton(
                        text = "Использовать QR код"
                    ) {
                        qrcode.scan()
                        if (qrcode.getSuccess()) {
                            //TODO qr invitation
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    MaterialTextField(text = code, hint = "Код приглашения")
                    MaterialButton(
                        text = "Использовать код приглашения"
                    ) {
                        //TODO code invitation
                    }
                }
            }
        }
    }

    return openDialog
}