package com.example.projecta.MainMenu.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.R
import com.example.projecta.MaterialButton
import com.example.projecta.Background
import com.example.projecta.Events
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.JoinDialog
import java.util.Date

@Composable
fun Participant(EventCardNavigation: () -> Unit) {
    Background()
    val joinDialog = JoinDialog()
    Scaffold(
        backgroundColor = Color.Transparent,
        bottomBar = {
            Box(contentAlignment = Alignment.Center) {
                MaterialButton(text="Присоединиться", modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                    onClick = { joinDialog.value = true })

            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally) {
            itemsIndexed(getEvents()) { index, item ->
                EventCard(item.name, item.description, EventCardNavigation)
            }
        }
    }


}

fun getEvents(): List<Events> {
    val eventsList = arrayListOf<Events>().apply {
        add(Events(
            organizers = arrayOf(1341U),
            name = "Битва хоров в лицее",
            start = 18404107UL,
            end = 18404107UL,
            description = "Битва хоров - формат музыкального соревнования, в котором состязаются хоровые коллективы",
            picture = "https://cdn-icons-png.flaticon.com/128/149/149452.png"))
        add(Events(
            organizers = arrayOf(1341U),
            name = "Битва хоров в лицее",
            start = 18404107UL,
            end = 18404107UL,
            description = "Битва хоров - формат музыкального соревнования, в котором состязаются хоровые коллективы",
            picture = "https://cdn-icons-png.flaticon.com/128/149/149452.png"))
    }

    return eventsList
}

@Composable
fun EventCard(title: String, description: String, EventCardNavigation:()->Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .heightIn(min = 100.dp, max = 150.dp)
            .clickable(onClick = EventCardNavigation),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.test_image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 2.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight(1000), maxLines = 2)
            Text(text = description, maxLines = 4)
        }
    }
}