package com.example.messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messenger.screens.EmailScreen
import com.example.messenger.screens.LoginScreen
import com.example.messenger.screens.PasswordScreen
import com.example.messenger.screens.WelcomeScreen
import com.example.messenger.ui.theme.MessengerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MessengerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "main"
                ) {
                    composable("main") {
                        WelcomeScreen(navController)
                    }
                    composable("email") {
                        EmailScreen(navController)
                    }
                    composable("password") {
                        PasswordScreen()
                    }

                    composable("login") {
                        LoginScreen()
                    }


                }
            }
        }
    }
}
