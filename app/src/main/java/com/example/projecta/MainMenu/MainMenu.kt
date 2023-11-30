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
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventCreator
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventOrganizerWindow
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventEdit
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventParticipants
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.EventCard
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.EventInvitation
import com.example.projecta.MainMenu.Screens.ProfileSubscreens.ProfileEdit
import com.example.projecta.ui.theme.MainColor


data class BottomMenuItem(val label: String, val icon: Int, val route: String)


private fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemsList = arrayListOf<BottomMenuItem>()


    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Профиль",
            icon = R.drawable.profile,
            route = "Profile"
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Участник",
            icon = R.drawable.participant,
            route = "Participant"
        )
    )
    bottomMenuItemsList.add(
        BottomMenuItem(
            label = "Организатор",
            icon = R.drawable.organizer,
            route = "Organizer"
        )
    )

    return bottomMenuItemsList
}

@Composable
fun MainMenu(startDestination: String = "Participant", signInNavigate: () -> Unit) {
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
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Image(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = item.icon),
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(item.label)
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MainColor,
                            selectedTextColor = MainColor
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            NavHost(navController = navController, startDestination = startDestination) {

                // BottomNavigation
                composable(route = "Participant") {
                    Participant(
                        EventCardNavigation = { navController.navigate("EventCard") }
                    )
                }
                composable(route = "Organizer") {
                    Organizer(
                        EventOrganizerWindowNavigation = { navController.navigate("EventOrganizerWindow") },
                        EventCreatorNavigation = { navController.navigate("EventCreator") }
                    )
                }
                composable(route = "Profile") {
                    Profile(
                        SignInNavigate = signInNavigate,
                        profileEditNavigate = { navController.navigate("ProfileEdit") }
                    )
                }

                // ProfileSubscreens
                composable("ProfileEdit") {
                    ProfileEdit() {
                        navController.popBackStack()
                    }
                }

                // ParticipantSubscreens
                composable("QrCodeParticipant") {
                    QrCodeParticipant(
                        BackNavigation =  { navController.popBackStack() }
                    )
                }

                composable("EventCard") {
                    EventCard(
                        QrCodeParticipantNavigation = { navController.navigate("QrCodeParticipant") },
                        BackNavigation =  { navController.popBackStack() }
                    )
                }
                composable("EventInvitation") {
                    EventInvitation(
                        MainMenuNavigation = { navController.navigate("Participant") },
                        BackNavigation = { navController.popBackStack() }
                    )
                }
                // OrganizerSubscreens
                composable("EventOrganizerWindow") {
                    EventOrganizerWindow(
                        EventEditNavigation = { navController.navigate("EventEdit") },
                        QrCodeOrganizerNavigation = { navController.navigate("QrCodeOrganizer") },
                        BackNavigation = { navController.popBackStack() },
                        EventParticipantsNavigation = { navController.navigate("EventParticipants") }
                    )
                }
                composable("EventParticipants") {
                    EventParticipants(
                        BackNavigation = { navController.popBackStack() }
                    )
                }
                composable("QrCodeOrganizer") {
                    QrCodeOrganizer(
                        BackNavigation = { navController.popBackStack() }
                    )
                }
                composable("EventEdit") {
                    EventEdit(
                        MainMenuNavigation = {
                            navController.navigate("Organizer") {
                                popUpTo(0)
                            }
                        },
                        BackNavigation = { navController.popBackStack() }
                    )
                }
                composable("EventCreator") {
                    EventCreator(
                        MainMenuNavigation = { navController.navigate("Organizer") },
                        BackNavigation =  { navController.popBackStack() }
                    )
                }
            }
        }
    }
}