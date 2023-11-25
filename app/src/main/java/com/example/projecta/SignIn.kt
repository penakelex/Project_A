package com.example.projecta

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.ui.screens.TextComponent


@ExperimentalMaterial3Api
@Composable
fun SignIn(toSignUp:()->Unit) {
    val email = remember {mutableStateOf("")}
    val password = remember {mutableStateOf("")}

    setBackground()
    Column {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp, alignment= Alignment.CenterVertically)
        ) {
            logoImage(modifier = Modifier
                .padding(bottom = 20.dp)
                .size(150.dp))
            Text("Вход", textAlign = TextAlign.Center, fontSize = 30.sp)
            materialTextField(text=email, hint="Почта")
            materialPasswordTextField(text=password, hint="Пароль")
            materialButton(modifier=Modifier.padding(top=40.dp), text="Новый аккаунт", onClick = toSignUp)
            materialButton(text="Вход") {}
        }
    }
}



@Composable
fun logoImage(modifier: Modifier = Modifier) {
    Image(
        modifier= modifier,
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
    )
}

@Composable
fun setBackground() {
    Image(
        modifier= Modifier.fillMaxSize(),
        contentScale= ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.background),
        contentDescription = null
    )
}

@ExperimentalMaterial3Api
@Composable
fun materialTextField(modifier: Modifier = Modifier, text: MutableState<String>, hint:String="") {
    TextField(
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
        modifier = modifier
            .border(1.dp, Color.LightGray, CircleShape)
            .width(250.dp)
            .height(50.dp),
        placeholder = { Text(modifier = Modifier.fillMaxWidth(), text=hint, textAlign = TextAlign.Center) },
    )
}

@ExperimentalMaterial3Api
@Composable
fun materialPasswordTextField(modifier: Modifier = Modifier, text: MutableState<String>, hint:String="") {
    TextField(
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
        modifier = modifier
            .border(1.dp, Color.LightGray, CircleShape)
            .width(250.dp)
            .height(50.dp),
        placeholder = { Text(modifier = Modifier.fillMaxWidth(), text=hint, textAlign = TextAlign.Center) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun materialButton(modifier: Modifier = Modifier, width: Int = 250, height: Int = 50, text:String="", onClick:()->Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(76, 182, 131)
        ),
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
    ) {
        Text(text, textAlign = TextAlign.Center)
    }
}