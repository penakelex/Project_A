package com.example.projecta.MainMenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.Background
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.QrCodeImage
import com.example.projecta.R
import com.example.projecta.TextCode
import com.example.projecta.YourImage

@Composable
fun QrCodeOrganizer() {
    Background()
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        )
        {
            Box(
                modifier = Modifier.size(100.dp)
            ) {
                YourImage(painterResource = painterResource(id = R.drawable.profile))
            }
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
            ) {
                QrCodeImage(painterResource = painterResource(id = R.drawable.qrkod))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
            ) {
                TextCode(text = "gi25ngp2j5")
                MaterialImageButton(
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp), 24, painterResource = painterResource(id = R.drawable.copy)
                ) {}
            }
            Text("Покажите QR-код, чтобы пригласить участника", fontSize = 22.sp, textAlign = TextAlign.Center)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MaterialImageButton(
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp),
                        50,
                        painterResource = painterResource(id = R.drawable.back)
                    ) {}
                    MaterialButton(
                        text = "Обновить", modifier = Modifier
                            .width(220.dp)
                            .height(60.dp)
                    ) {}
                }
            }
        }
    }
}
