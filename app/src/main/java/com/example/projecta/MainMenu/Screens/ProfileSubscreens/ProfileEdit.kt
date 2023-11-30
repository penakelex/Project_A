package com.example.projecta.MainMenu.Screens.ProfileSubscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.example.projecta.MaterialTextField
import com.example.projecta.R
import com.example.projecta.User
import com.example.projecta.UserUpdate

@Composable
fun ProfileEdit(profileUser:MutableState<User>, BackNavigation:()->Unit) {
    val name: MutableState<String> = remember{mutableStateOf(profileUser.value.name)}
    val surname: MutableState<String> = remember{mutableStateOf(profileUser.value.surname)}
    val patronymic: MutableState<String> = remember{mutableStateOf(profileUser.value.patronymic)}
    val email: MutableState<String> = remember{ profileUser.value.email?.let { mutableStateOf(it) } ?: mutableStateOf("") }
    val phone: MutableState<String> = remember{ profileUser.value.phone?.let { mutableStateOf(it) } ?: mutableStateOf("")}
    val status: MutableState<String> = remember{mutableStateOf(profileUser.value.status)}

    Background()
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(), colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Column() {
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.empty_avatar),
                        contentDescription = null
                    )
                    MaterialButton(
                        text = "Изменить\nаватар",
                        onClick = {}
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MaterialButton(
                modifier = Modifier
                    .padding(0.dp),
                text = "Сохранить",
                onClick = {
                    profileUser.value = User(phone.value, email.value, name.value, surname.value, patronymic.value, status.value)
                    val userUpdate = UserUpdate(phone.value, name.value, surname.value, patronymic.value, status.value)
                    BackNavigation()
                }
            )
        }
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
        ) {
            item {
                ParamEditor("Имя", name)
            }
            item {
                ParamEditor("Фамилия", surname)
            }
            item {
                ParamEditor("Отчество", patronymic)
            }
            item {
                ParamEditor("Почта", email)
            }
            item {
                ParamEditor("Телефон", phone)
            }
            item {
                ParamEditor("Статус", status)
            }
        }
    }
}

@Composable
fun ParamEditor(key: String, defaultValue: MutableState<String>) {
    var param = remember { mutableStateOf(defaultValue) }
    Column() {
        Text(key, fontSize = 20.sp, fontWeight = FontWeight(1000))
        MaterialTextField(modifier=Modifier.fillMaxWidth().padding(start = 10.dp), text =defaultValue, hint=key, fontSize = 17.sp)
    }
}