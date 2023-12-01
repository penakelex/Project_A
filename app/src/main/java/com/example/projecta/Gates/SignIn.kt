package com.example.projecta.Gates

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.LogoImage
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialPasswordTextField
import com.example.projecta.MaterialTextField
import com.example.projecta.Background
import com.example.projecta.QRCode
import com.example.projecta.Response
import com.example.projecta.UserLogin
import com.example.projecta.activity
import com.example.projecta.loginUser
import com.example.projecta.qrcode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlin.concurrent.thread

@SuppressLint("CommitPrefEdits")
@ExperimentalMaterial3Api
@Composable
fun SignIn(signUpNavigate: () -> Unit, mainMenuNavigate: () -> Unit) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val context = LocalContext.current

    Background()
    MaterialButton(
        modifier = Modifier
            .width(140.dp)
            .height(70.dp),
        text = "Запасной\nвход",
        onClick = mainMenuNavigate
    )
    Column {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                20.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            LogoImage(modifier = Modifier
                .padding(bottom = 20.dp)
                .size(150.dp))
            Text("Вход", textAlign = TextAlign.Center, fontSize = 30.sp)
            MaterialTextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp),
                text = email,
                hint = "Почта"
            )
            MaterialPasswordTextField(
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp),
                text = password,
                hint = "Пароль"
            )
            MaterialButton(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .width(250.dp)
                    .height(50.dp),
                text = "Новый аккаунт",
                onClick = signUpNavigate
            )
            MaterialButton(
                modifier = Modifier
                    .width(250.dp)
                    .height(50.dp),
                text = "Вход",
                onClick = {
                    val ul = UserLogin(phone=null, email=email.value, password = password.value)
                    val sharedPf = activity.getPreferences(Context.MODE_PRIVATE)

                    try {
                        runBlocking {
                            launch(Dispatchers.Default) {
                                val token: String? = Json.decodeFromString<Response<String>>(loginUser(ul, "http://0.0.0.0:8080")).data
                                sharedPf.edit().putString("token", token)
                            }
                        }
                        mainMenuNavigate()
                    } catch (_: Exception) {
                        Toast.makeText(context, "Ошибка авторизации", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}

