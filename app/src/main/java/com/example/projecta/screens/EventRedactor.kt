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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.materialButton
import com.example.projecta.ui.theme.GrayBack
import com.example.projecta.ui.theme.GreenBack
import com.example.projecta.ui.theme.TextBox
import com.example.projecta.ui.theme.WhiteBack

@Composable
fun EventRedactor() {
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
                materialButton(modifier = Modifier
                    .padding(60.dp)
                    .height(40.dp)
                    .width(165.dp), text = "Указать картинку") {}
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
                    .padding(bottom = 15.dp, top = 5.dp, start = 15.dp, end = 15.dp)
                    .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    /*verticalArrangement = Arrangement.spacedBy(5.dp)*/
                ){
                    HeadingTextComponent(labelValue = "Заголовок")

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ){
                        TextComponent(labelValue = "Дата начала", modifier = Modifier
                            .width(167.5f.dp)
                            .height(65.dp)
                            .padding(end = 2.dp)
                            .clip(RoundedCornerShape(4.dp)))
                        TextComponent(labelValue = "Дата конца", modifier = Modifier
                            .width(167.5f.dp)
                            .height(65.dp)
                            .padding(start = 2.dp)
                            .clip(RoundedCornerShape(4.dp)))
                    }
                    TextComponent(labelValue = "Описание", modifier = Modifier
                        .fillMaxWidth()
                        .height(456.dp))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(276.dp, 50.dp)
                        .height(50.dp),
                        horizontalArrangement = Arrangement.Start
                    ){
                        materialImageButton(modifier = Modifier
                            .padding(end = 5.dp, top = 11.dp)
                            .height(50.dp)
                            .width(50.dp), painterResource(id = com.example.projecta.R.drawable.back)){}
                        materialButton(modifier = Modifier
                            .padding(start = 5.dp, top = 11.dp)
                            .fillMaxWidth()
                            .height(50.dp), text = "Сохранить"){}
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewEventRedScreen(){
    EventRedactor()
}