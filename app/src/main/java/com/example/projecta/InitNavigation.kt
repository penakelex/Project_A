package com.example.projecta

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projecta.Gates.SignIn
import com.example.projecta.Gates.SignUp
import com.example.projecta.MainMenu.MainMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun initNavigationGate() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "SignIn") {
        composable("SignIn") {
            SignIn(
                signUpNavigate = {
                    navController.navigate("SignUp") {
                        popUpTo(0)
                    }
                },
                mainMenuNavigate = {
                    navController.navigate("MainMenu") {
                        popUpTo(0)
                    }
                }
            )
        }
        composable("SignUp") {
            SignUp(
                MainMenuNavigate = {
                    navController.navigate("MainMenu") {
                        popUpTo(0)
                    }
                },
                signInNavigate = {
                    navController.navigate("SignIn") {
                        popUpTo(0)
                    }
                }
            )
        }
        composable("MainMenu") {
            MainMenu(
                signInNavigate = {
                    navController.navigate("SignIn") {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}