package com.example.projecta.MainMenu.Screens.ParticipantSubscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.projecta.Background
import com.example.projecta.DescriptionTextEvent
import com.example.projecta.FromTimeTextEvent
import com.example.projecta.HeadingTextEvent
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.R
import com.example.projecta.ToTimeTextEvent

@Composable
fun EventInvitation(
    BackNavigation:()->Unit,
    MainMenuNavigation:()->Unit
) {
    Background()
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.default_image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom
                ) {
                    MaterialImageButton(
                        modifier = Modifier.padding(top = 11.dp),
                        painterResource = painterResource(id = R.drawable.back),
                        onClick = BackNavigation
                    )
                    MaterialButton(text = "Присоединиться", onClick = MainMenuNavigation)
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, start = 15.dp, end = 15.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {
                    HeadingTextEvent(text = "Вебинар по разработке")
                    FromTimeTextEvent(text = "Первое января, 2024, 14:30")
                    ToTimeTextEvent(text = "Первое января, 2024, 15:40")
                    DescriptionTextEvent(text = "ojgowsemjopgmjeopswm-ORKIOJOBPGJ[OPJU,BY[9POJ,UYOO[BPR,JOSJ,OPB,JSOPJjpotjd,r9pov,jpod,jrovgprjdopjbpoidjhi0oprd,jiopjdpobjop,j[opprbj5iobuj9sruyoskbosfjopdb,kkbsopi[jrtgb,jrdipsj,gbipords,jbojsdiogbj,srdop[bjgodpxji[pgjkdsopbg,rsidhjgip[srej,gbvpishjiogphgbpopsnmsdhpbpmpnspopmnhopszmnhbopsedmsnophbmnsesopsdmhnbspsodesmnshpobpnmpspohbmnespdpopshmbnosopsdnmshsbopesnmdopsghpsbnmsopdshbsnmospshbnsmps[hmnbpesnsmsopnm sopshnmopepsnmbhopesnmohbpnesophbnopeshbnopesnbhopnmshgopsnhbopesnmbhopensmbhopesndophbn[esnhbmoesdnmbhoesdmnblsmgbopsdmgvopemsopgmnbpvop'sers'mgsblsm;cxmnbpnmseropinmgbpaesnmgpoijg-0aoqekjo0ptkwopjtopwafmanmgfopamgjpojwamgowpw[sgmjswiopajmapowejmpwiponeamopigmnjEionjmgFN")
                }
            }
        }

    }
}