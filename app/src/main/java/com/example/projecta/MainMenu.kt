package com.example.projecta

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainMenu() {
    val contextForToast = LocalContext.current.applicationContext
    setBackground()
    Box(modifier=Modifier.fillMaxSize()) {
        BottomNavigation(
            modifier = Modifier.align(alignment = Alignment.BottomCenter),
            backgroundColor = Color.White
        ) {
            prepareBottomMenu().forEach { menuItem ->
                // adding each item
                var selectedItem:String = ""
                BottomNavigationItem(
                    selected = (selectedItem == menuItem.label),
                    onClick = {
                        selectedItem = menuItem.label
                        Toast.makeText(
                            contextForToast,
                            menuItem.label, Toast.LENGTH_SHORT
                        ).show()
                    },
                    icon = {
                        Image(
                            painter = painterResource(menuItem.icon),
                            contentDescription = menuItem.label,
                            modifier = Modifier.size(40.dp)
                        )
                    },
                    label = {
                        Text(text = menuItem.label)
                    },
                    enabled = true
                )
            }
        }
    }

}

data class BottomMenuItem(val label: String, val icon: Int)

private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()

    // add menu items
    bottomMenuItemsList.add(BottomMenuItem(label = "Profile", icon = R.drawable.profile ))
    bottomMenuItemsList.add(BottomMenuItem(label = "Participant", icon = R.drawable.participant))
    bottomMenuItemsList.add(BottomMenuItem(label = "Organizer", icon = R.drawable.organizer))

    return bottomMenuItemsList
}