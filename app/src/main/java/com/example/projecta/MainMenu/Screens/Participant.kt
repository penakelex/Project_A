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
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.JoinDialog

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
            itemsIndexed(eventsGetter()) { index, item ->
                EventCard(item.title, item.description, EventCardNavigation)
            }
        }
    }


}

fun eventsGetter(): List<EventItem> {
    val bottomMenuItemsList = arrayListOf<EventItem>()


    bottomMenuItemsList.add(
        EventItem(
            title = "Битва хоров в лицее",
            description = "Битва хоров - формат музыкального соревнования, в котором состязаются хоровые коллективы.\n" +
                    "\n" +
                    "Многие, в этом году, впервые узнали что это такое, а кто-то после двухлетнего перерыва, связанного с пандемией коронавируса, вновь окунулся в атмосферу музыки.\n" +
                    "\n" +
                    "Конкурс проходит в два тура: в первом туре коллективы поют тематическую песню (в этом году тематическая песня была посвящена близким и родным людям), а во втором туре - новогоднюю песню. "
        )
    )
    bottomMenuItemsList.add(
        EventItem(
            title = "Вебинар по разработке андроид приложений",
            description = "На вебинаре мы рассмотрим и обсудим самые актуальные тренды мобильной разработки под Android на 2022 год. Поговорим о том, какие нововедения вышли в 2021 году и что будет актуально для новых проектов в 2022 году.\n" +
                    "\n" +
                    "План вебинара:\n" +
                    "\n" +
                    "1) SingleActivity Application, NavigationController\n" +
                    "2) Декларативная разметка экрана Jetpack Compose, замена xml макетов\n" +
                    "3) Карутины, flow, потоковая обработка событий архитектуры MVVM, замена LiveData\n" +
                    "4) Использование карутин в Jetpack Compose\n" +
                    "5) State Jetpack Compose\n" +
                    "6) Dependency Injection\n" +
                    "7) Dagger 2\n" +
                    "8) Hilt"
        )
    )

    return bottomMenuItemsList
}

data class EventItem(val title: String, val description: String)

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