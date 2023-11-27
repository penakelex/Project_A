package com.example.projecta.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projecta.MaterialButton
import com.example.projecta.R
import com.example.projecta.materialButton
import com.example.projecta.ui.theme.GrayBack
import com.example.projecta.ui.theme.GreenBack
import com.example.projecta.ui.theme.WhiteBack

@Composable
fun PassOnEvent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayBack)
    ){
        Column(
            modifier = Modifier
                .padding(14.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.2f)
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp,
                        )
                    ),
                backgroundColor = GreenBack
            ){
                IamgeEvent(painterResource = painterResource(id = R.drawable.exemple))
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomEnd = 15.dp,
                            bottomStart = 15.dp,
                        )
                    ),
                backgroundColor = Color.White,

                ){
                Column(modifier = Modifier
                    .padding(bottom = 15.dp, top = 8.dp, start = 8.dp, end = 8.dp)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    /*verticalArrangement = Arrangement.spacedBy(5.dp)*/
                ){
                    HeadingTextEvent("Вебинар по разработке")
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 15.dp, end = 15.dp),
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        FromTimeTextEvent(text = "Первое января, 2024, 14:30")
                        ToTimeTextEvent(text = "Первое января, 2024, 15:40")
                        DiscriptionTextEvent()
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .defaultMinSize(276.dp, 50.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.Bottom
                    ){
                        materialImageButton(modifier = Modifier
                            .padding(end = 5.dp, top = 11.dp)
                            .height(50.dp)
                            .width(50.dp), painterResource(id = com.example.projecta.R.drawable.back)){}
                        MaterialButton(modifier = Modifier
                            .padding(start = 5.dp, top = 11.dp)
                            .fillMaxWidth()
                            .height(50.dp), text = "Показать пропуск"){}
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPassEvent(){
    PassOnEvent()
}