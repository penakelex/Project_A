package com.example.projecta.MainMenu.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.Background
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.R
import com.example.projecta.User

@Composable
fun Profile(
    profileEditNavigate: () -> Unit,
    SignInNavigate: () -> Unit,
    profileUser: MutableState<User>
) {

    Background()
    Card(modifier = Modifier
        .padding(10.dp)
        .fillMaxSize(), colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Row(modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.empty_avatar),
                contentDescription = null
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.spacedBy(5.dp, alignment = Alignment.CenterHorizontally)) {
            MaterialImageButton(painterResource = painterResource(id = R.drawable.exit), onClick = SignInNavigate)
            MaterialButton(text="Редактировать", onClick = profileEditNavigate)
        }
        LazyColumn(modifier = Modifier.padding(10.dp))
        {
            item {
                ParamView("Имя", profileUser.value.name)
            }
            item {
                ParamView("Фамилия", profileUser.value.surname)
            }
            item {
                ParamView("Отчество", profileUser.value.patronymic)
            }
            item {
                profileUser.value.email?.let { ParamView("Почта", it) } ?: ""
            }
            item {
                profileUser.value.phone?.let { ParamView("Телефон", it) } ?: ""
            }
            item {
                ParamView("Статус", profileUser.value.status)
            }
        }
    }
}

@Composable
fun ParamView(key:String, value:String) {
    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Text(key, fontSize = 20.sp, fontWeight = FontWeight(1000))
        Text(value, fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp))
    }
}

fun getUser(): User {
    return User("88005553535", "exaple@email.net", "Name", "Surname", "Patronymic", "Ученик 11-3")
}