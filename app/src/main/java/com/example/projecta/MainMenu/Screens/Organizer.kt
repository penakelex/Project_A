package com.example.projecta.MainMenu.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.projecta.Background
import com.example.projecta.MaterialButton

@Composable
fun Organizer(EventOrganizerWindowNavigation: () -> Unit, EventCreatorNavigation: () -> Unit) {
    Background()
    Scaffold(
        backgroundColor = Color.Transparent,
        bottomBar = {
            Box(contentAlignment = Alignment.Center) {
                MaterialButton(text="Создать мероприятие", modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                    onClick = EventCreatorNavigation)

            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally) {
            items(10) {index ->
                EventCard("Hello", "World!", EventOrganizerWindowNavigation)
            }
        }
    }
}