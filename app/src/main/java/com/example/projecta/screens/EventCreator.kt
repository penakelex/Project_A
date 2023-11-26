package com.example.projecta.screens

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Shapes
import androidx.compose.material.Surface
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.logoImage
import com.example.projecta.materialButton
import com.example.projecta.materialPasswordTextField
import com.example.projecta.materialTextField
import com.example.projecta.setBackground
import com.example.projecta.ui.theme.GrayBack
import com.example.projecta.ui.theme.GreenBack
import com.example.projecta.ui.theme.TextBox
import com.example.projecta.ui.theme.WhiteBack

@Composable
fun EventCreator() {
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
                        .fillMaxHeight(0.9f))
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(276.dp, 50.dp)
                        .height(50.dp),
                        horizontalArrangement = Arrangement.Start
                    ){
                        materialImageButton(modifier = Modifier
                            .padding(end = 5.dp, top = 11.dp)
                            .height(50.dp)
                            .heightIn(40.dp)
                            .width(50.dp), painterResource(id = com.example.projecta.R.drawable.back)){}
                        materialButton(modifier = Modifier
                            .padding(start = 5.dp, top = 11.dp)
                            .fillMaxWidth()
                            .heightIn(40.dp)
                            .height(50.dp), text = "Создать"){}
                    }
                }
            }
        }
    }

}

@Composable
fun HeadingTextComponent(labelValue: String){
    val textValue = remember{
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .height(66.dp),
        label = { androidx.compose.material.Text(text = labelValue, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
        colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black,
            backgroundColor = TextBox
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        textStyle = TextStyle(fontSize=20.sp, fontWeight = FontWeight.Bold),
        onValueChange = {
            if (it.length <= 30) textValue.value = it
        },
        singleLine = true,
    )
    Text(
        text = "${textValue.value.length} / 30",
        textAlign = TextAlign.End,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.fillMaxWidth().padding(end = 16.dp)
    )
}
@Composable
fun TextComponent(labelValue: String, modifier: Modifier = Modifier){

    val textValue = remember{
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = modifier,
        label = { androidx.compose.material.Text(text = labelValue, fontSize = 18.sp) },
        colors = androidx.compose.material.TextFieldDefaults.outlinedTextFieldColors(
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black,
            backgroundColor = TextBox
        ),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        textStyle = TextStyle(fontSize=15.sp),
        onValueChange = {
            textValue.value = it
        }
    )
}

@Composable
fun materialImageButton(modifier: Modifier = Modifier, painterResource: Painter, onClick:()->Unit) {

    androidx.compose.material3.IconButton(
        onClick = onClick,
        modifier = modifier
            .width(250.dp)
            .height(50.dp)
    ) {
        Image(painter = painterResource, modifier = Modifier.size(32.dp), contentDescription = "")

    }
}

@Preview
@Composable
fun PreviewEventCreatorScreen(){
    EventCreator()
}