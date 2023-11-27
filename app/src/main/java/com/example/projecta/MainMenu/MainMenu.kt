package com.example.projecta.MainMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.projecta.MainMenu.Screens.Organizer
import com.example.projecta.MainMenu.Screens.Participant
import com.example.projecta.MainMenu.Screens.Profile
import com.example.projecta.R
import com.example.projecta.Background
import com.example.projecta.MainMenu.Screens.ProfileSubscreens.ProfileEdit
import com.example.projecta.ui.theme.MainColor


data class BottomMenuItem(val label: String, val icon: Int, val route: String)


private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()


    bottomMenuItemsList.add(BottomMenuItem(label = "Профиль", icon = R.drawable.profile, route = "Profile" ))
    bottomMenuItemsList.add(BottomMenuItem(label = "Участник", icon = R.drawable.participant, route = "Participant"))
    bottomMenuItemsList.add(BottomMenuItem(label = "Организатор", icon = R.drawable.organizer, route = "Organizer"))

    return bottomMenuItemsList
}

@Composable
fun MainMenu(startDestination:String = "Participant") {
    Background()
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                prepareBottomMenu().forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState=true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Image(
                                modifier=Modifier.size(30.dp),
                                painter = painterResource(id = item.icon),
                                contentDescription = null)
                        },
                        label = {
                            Text(item.label)
                        },
                        colors = NavigationBarItemDefaults.colors(selectedIconColor = MainColor, selectedTextColor = MainColor)
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
            NavHost(navController = navController, startDestination = startDestination) {
                composable(route = "Participant") {
                    Participant()
                }
                composable(route = "Organizer") {
                    Organizer()
                }
                composable(route = "Profile") {
                    Profile() {
                        navController.navigate("ProfileEdit")
                    }
                }
                composable("ProfileEdit") {
                    ProfileEdit() {
                        navController.navigate("Profile")
                    }
                }
            }
        }
    }
}