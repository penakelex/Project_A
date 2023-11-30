package com.example.projecta.MainMenu.Screens.OrganizerSubscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.projecta.Background
import com.example.projecta.MainMenu.Screens.EventCard
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.JoinDialog
import com.example.projecta.MainMenu.Screens.eventsGetter
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.R

@Composable
fun EventParticipants(BackNavigation:()->Unit) {
    Background()
    val joinDialog = JoinDialog()
    Scaffold(
        backgroundColor = Color.Transparent,
        bottomBar = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                MaterialImageButton(
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp),
                    painterResource = painterResource(id = R.drawable.back),
                    onClick = BackNavigation)
                MaterialButton(text="Обновить", modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                    onClick = {})
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues), horizontalAlignment = Alignment.CenterHorizontally) {
            itemsIndexed(eventsGetter()) { index, item ->
                //EventCard(item.title, item.description, EventCardNavigation)
            }
        }
    }
}