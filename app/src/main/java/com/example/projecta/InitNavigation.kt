package com.example.projecta

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecta.Gates.SignIn
import com.example.projecta.Gates.SignUp
import com.example.projecta.MainMenu.MainMenu
import com.example.projecta.MainMenu.QrCodeParticipant
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventCreator
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventRedactor
import com.example.projecta.MainMenu.Screens.OrganizerSubscreens.EventWindow
import com.example.projecta.MainMenu.Screens.ParticipantSubscreens.PassOnEvent
import com.example.projecta.MainMenu.Screens.ProfileSubscreens.ProfileEdit

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun initNavigationGate() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "QrCodeParticipant") {
        composable("SignIn") {
            SignIn(
                signUpNavigate = {
                    navController.navigate("SignUp") {
                        popUpTo("SignIn") {
                            inclusive = true
                        }
                    }
                },
                mainMenuNavigate = {

                }
            )
        }
        composable("SignUp") {
            SignUp(
                signInNavigate = {
                    navController.navigate("SignIn") {
                        popUpTo("SignUp") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("MainMenu") {
            MainMenu()
        }

        composable("QrCodeParticipant") {
            QrCodeParticipant()
        }
    }
}