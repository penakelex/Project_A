package com.example.projecta.MainMenu.Screens

import android.app.Application
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.projecta.Background
import com.example.projecta.MaterialButton
import com.example.projecta.R

@Composable
fun Profile(profileEditNavigate:()->Unit) {
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
            .padding(10.dp), horizontalArrangement = Arrangement.Center) {
            MaterialButton(text="Редактировать", onClick = profileEditNavigate)
        }
        LazyColumn(modifier = Modifier
            .padding(10.dp)) {
            paramsGetter().forEach {
                item {
                    ParamView(it.key, it.value)
                }
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

fun paramsGetter(): MutableMap<String, String> {
    val params = mutableMapOf<String, String>()
    params["Name"] = "Name"
    params["Surname"] = "Surname"
    params["Patronymic"] = "Patronymic"
    params["Email"] = "exaple@email.net"
    params["Phone"] = "88005553535"
    params["Class"] = "11-3"
    return params
}