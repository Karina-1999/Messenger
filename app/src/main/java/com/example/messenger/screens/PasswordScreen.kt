package com.example.messenger.screens

import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PasswordScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(color = Color(0xFFE3DFCE))
            .padding(vertical = 40.dp, horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Введите пароль",
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4C050C)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Введите пароль") },
            shape = CircleShape,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(80.dp))

        Button(onClick = {navController.navigate("home")},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4C050C),
                contentColor = Color(0xFFE3DFCE)),
        ){
            Text(
                text = "Войти",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}