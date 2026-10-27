package com.example.messenger

import android.R.attr.type
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.messenger.screens.EmailScreen
import com.example.messenger.screens.HomeScreen
import com.example.messenger.screens.LoginScreen
import com.example.messenger.screens.PasswordScreen
import com.example.messenger.screens.WelcomeScreen
import com.example.messenger.ui.theme.MessengerTheme
import androidx.navigation.NavType
import androidx.navigation.navArgument

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
                    composable(
                        route = "password/{email}",
                        arguments = listOf(navArgument("email") { type = NavType.StringType })
                    ){ backStackEntry ->
                            val email = requireNotNull(backStackEntry.arguments?.getString("email"))

                        PasswordScreen(navController, email = email)
                    }

                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("home") {
                        HomeScreen()
                    }


                }
            }
        }
    }
}
