package com.example.projecta.screens

import androidx.compose.foundation.Image
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.projecta.R
import com.example.projecta.materialButton
import com.example.projecta.ui.theme.GrayBack
import com.example.projecta.ui.theme.GreenBack
import com.example.projecta.ui.theme.WhiteBack

@Composable
fun EventWindow() {
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
                backgroundColor = WhiteBack,

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
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    ){
                        materialImageButton(modifier = Modifier
                            .padding(top = 11.dp)
                            .height(50.dp)
                            .heightIn(40.dp)
                            .width(50.dp), painterResource(id = R.drawable.back)
                        ){}
                        materialButton(modifier = Modifier
                            .padding(top = 11.dp)
                            .width(190.dp)
                            .heightIn(40.dp)
                            .height(50.dp), text = "Пригласить"
                        ){}
                        materialImageButton(modifier = Modifier
                            .padding(top = 11.dp)
                            .height(50.dp)
                            .heightIn(40.dp)
                            .width(50.dp), painterResource(id = R.drawable.setting)
                        ){}
                    }
                }
            }
        }
    }
}

@Composable
fun IamgeEvent(painterResource: Painter){
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource,
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeadingTextEvent(text: String = "Название вашего мероприятия"){
    Text(text = text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
}
@Composable
fun FromTimeTextEvent(text: String = "nn.nn.nn"){
    Text(text = "Начало: "+text, fontSize = 18.sp, maxLines = 1)
}
@Composable
fun ToTimeTextEvent(text: String = "nn.nn.nn"){
    Text(text = "Конец: "+text, fontSize = 18.sp, maxLines = 1)
}

@Composable
fun DiscriptionTextEvent(text: String = "что-то"){
    Text(text = "Описание: "+text, fontSize = 18.sp, maxLines = 22)
}


@Preview
@Composable
fun PreviewEventWindScreen(){
    EventWindow()
}