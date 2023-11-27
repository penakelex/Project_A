package com.example.projecta.MainMenu.Screens.OrganizerSubscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projecta.Background
import com.example.projecta.HeadingTextComponent
import com.example.projecta.MaskVisualTransformation
import com.example.projecta.MaterialButton
import com.example.projecta.MaterialImageButton
import com.example.projecta.R
import com.example.projecta.TextComponent
import com.example.projecta.ui.theme.TextBox

@Composable
fun EventCreator() {
    Background()

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp), colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f),
            contentAlignment = Alignment.Center

        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.default_image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            MaterialButton(
                modifier = Modifier
                    .height(40.dp)
                    .width(165.dp),
                text = "Указать картинку"
            ) {}
        }
        Column(
            modifier = Modifier
                .padding(bottom = 15.dp, top = 5.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            /*verticalArrangement = Arrangement.spacedBy(5.dp)*/
        ) {
            HeadingTextComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(81.dp),
                labelValue = "Заголовок",
                maxLenght = 50
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextComponent(
                    labelValue = "Дата начала",
                    modifier=Modifier.width(170.dp).height(81.dp),
                    mask = MaskVisualTransformation("##/##/#### ##:##"),
                    maxLenght = 12,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                TextComponent(
                    labelValue = "Дата начала",
                    modifier=Modifier.width(170.dp).height(81.dp),
                    mask = MaskVisualTransformation("##/##/#### ##:##"),
                    maxLenght = 12,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Scaffold(
                bottomBar = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .defaultMinSize(276.dp, 50.dp)
                            .height(50.dp),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        MaterialImageButton(
                            modifier = Modifier
                                .padding(end = 5.dp, top = 11.dp),
                            painterResource=painterResource(id = R.drawable.back)
                        ) {}
                        MaterialButton(
                            modifier = Modifier
                                .padding(start = 5.dp, top = 11.dp)
                                .fillMaxWidth()
                                .heightIn(40.dp)
                                .height(50.dp), text = "Создать"
                        ) {}
                    }
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    TextComponent(
                        labelValue = "Описание",
                        textFieldModifier = Modifier.fillMaxSize(),
                        maxLenght = 500
                    )
                }

            }
        }
    }
}


