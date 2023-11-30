package com.example.projecta

import android.widget.TextView.SavedState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.ui.theme.MainColor
import com.example.projecta.ui.theme.TextBox

@Composable
fun LogoImage(modifier: Modifier = Modifier) {
    Image(
        modifier= modifier,
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
    )
}

@Composable
fun Background() {
    Image(
        modifier= Modifier.fillMaxSize(),
        contentScale= ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.background),
        contentDescription = null
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialTextField(modifier: Modifier = Modifier, text: MutableState<String>, hint:String="", fontSize:TextUnit=15.sp) {
    TextField(
        modifier = modifier.border(1.dp, Color.LightGray, CircleShape),
        value = text.value,
        onValueChange = {newText -> text.value=newText},
        singleLine = true,
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize = fontSize),
        placeholder = {Text(modifier = Modifier.fillMaxWidth(), text=hint, textAlign = TextAlign.Center, fontSize = fontSize)}
    )
}

@ExperimentalMaterial3Api
@Composable
fun MaterialPasswordTextField(modifier: Modifier = Modifier, text: MutableState<String>, hint:String="", fontSize:TextUnit=15.sp) {
    TextField(
        modifier = modifier
            .border(1.dp, Color.LightGray, CircleShape),
        value = text.value,
        onValueChange = {newText -> text.value=newText},
        singleLine = true,
        shape = CircleShape,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center, fontSize=fontSize),
        placeholder = { Text(modifier = Modifier.fillMaxWidth(), text=hint, textAlign = TextAlign.Center, fontSize=fontSize) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
    )
}

@Composable
fun MaterialButton(modifier: Modifier = Modifier, text:String="", onClick:()->Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MainColor
        ),
        modifier = modifier
    ) {
        Text(text, textAlign = TextAlign.Center, fontSize = 20.sp)
    }
}
@Composable
fun MaterialImageButton(modifier: Modifier = Modifier, size: Int = 32, painterResource: Painter, onClick:()->Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Image(painter = painterResource, modifier = Modifier.size(size.dp), contentDescription = "", contentScale= ContentScale.Fit)

    }
}

@Composable
fun HeadingTextEvent(text: String = "Название вашего мероприятия") {
    Text(text = text, fontWeight = FontWeight.Bold, fontSize = 20.sp)
}

@Composable
fun FromTimeTextEvent(text: String = "dd.mm.yyyy hh:mm") {
    Text(text = "Начало: " + text, fontSize = 18.sp, maxLines = 1)
}

@Composable
fun ToTimeTextEvent(text: String = "dd.mm.yyyy hh:mm") {
    Text(text = "Конец: " + text, fontSize = 18.sp, maxLines = 1)
}

@Composable
fun DescriptionTextEvent(text: String = "что-то") {
    Text(text = "Описание: ", fontSize = 18.sp, maxLines = 22)
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState())) {
        Text(text = text, fontSize = 18.sp, maxLines = 22)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeadingTextComponent(
    modifier: Modifier = Modifier,
    textFieldModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    labelValue: String = "",
    maxLenght: Int = 0
) {
    val textValue = remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (maxLenght != 0) {
                Text(
                    text = "${textValue.value.length} / $maxLenght",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = textModifier
                        .height(15.dp)
                        .fillMaxWidth()
                        .padding(end = 10.dp)
                )
            }
        })
    {paddingValues ->
        TextField(
            modifier = textFieldModifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .padding(paddingValues)
                .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp)),
            label = {
                androidx.compose.material.Text(
                    text = labelValue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black,
                containerColor = TextBox,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions.Default,
            value = textValue.value,
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
            onValueChange = {
                if (maxLenght != 0) {
                    if (it.length <= maxLenght) {
                        textValue.value = it
                    }
                } else {
                    textValue.value = it
                }
            },
            singleLine = true
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextComponent(
    modifier:Modifier=Modifier,
    textFieldModifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    labelValue: String = "",
    maxLenght: Int = 0,
    mask: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine:Boolean=false
) {

    val textValue = remember {
        mutableStateOf("")
    }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (maxLenght != 0) {
                Text(
                    text = "${textValue.value.length} / $maxLenght",
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.caption,
                    modifier = textModifier
                        .height(15.dp)
                        .padding(end = 10.dp)
                        .fillMaxWidth()
                )
            }
        }
    ) { paddingValues ->
        TextField(
            modifier = textFieldModifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .padding(paddingValues)
                .border(1.dp, Color.LightGray, RoundedCornerShape(5.dp)),
            label = { Text(text = labelValue, fontSize = 18.sp) },
            colors = TextFieldDefaults.textFieldColors(
                focusedLabelColor = Color.Black,
                cursorColor = Color.Black,
                containerColor = TextBox,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            keyboardOptions = keyboardOptions,
            value = textValue.value,
            textStyle = androidx.compose.ui.text.TextStyle(fontSize = 15.sp),
            onValueChange = {
                if (maxLenght != 0) {
                    if (it.length <= maxLenght) {
                        textValue.value = it
                    }
                } else {
                    textValue.value = it
                }

            },
            visualTransformation = mask,
            singleLine = singleLine
        )
    }
}

@Composable
fun QrCodeImage(painterResource: Painter) {
    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
        painter = painterResource,
        contentDescription = null
    )
}

@Composable
fun TextCode(text: String = "Секундочку") {
    Text(text = text, fontSize = 24.sp, fontWeight = FontWeight.Bold, maxLines = 1, textAlign = TextAlign.Right)
}

@Composable
fun YourImage(painterResource: Painter, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource,
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}