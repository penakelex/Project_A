package com.example.projecta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.ui.theme.MainColor
import java.time.format.TextStyle

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
fun MaterialPasswordTextField(modifier: Modifier = Modifier, text: MutableState<String>, hint:String="") {
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
        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
        placeholder = { Text(modifier = Modifier.fillMaxWidth(), text=hint, textAlign = TextAlign.Center) },
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