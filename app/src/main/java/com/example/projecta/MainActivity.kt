package com.example.projecta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "MainMenu") {
                composable("SignIn") {
                    SignIn() {
                        navController.navigate("SignUp") {
                            popUpTo("SignIn") {
                                inclusive = true
                            }
                        }
                    }
                }
                composable("SignUp") {
                    SignUp() {
                        navController.navigate("SignIn") {
                            popUpTo("SignUp") {
                                inclusive = true
                            }
                        }
                    }
                }
                composable("MainMenu") {
                    MainMenu()
                }
            }
        }
    }
}