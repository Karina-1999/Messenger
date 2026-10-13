package com.example.messenger.screens

import android.R.attr.onClick
import android.R.attr.text
import android.R.attr.top
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Column(
    modifier = Modifier
        .fillMaxWidth()
        .fillMaxSize()
        .background(color = Color((0xFF8dafc6))),

        verticalArrangement = Arrangement.spacedBy(24.dp)

    ){
        Text(text = "Напишите свой email для регистрации или входа в аккаунт",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 200.dp, start = 20.dp, end = 20.dp)
                .displayCutoutPadding(),

            color = Color(0xFF4C050C)
        )
        OutlinedTextField(
            value = text,
            onValueChange = {text = it},
            label = { Text("Введите email") },
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = {navController.navigate("password")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4C050C)),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 210.dp)

        ){
            Text(
                text = "Продолжить",
                fontSize = 20.sp,
                color = Color(0xFF8dafc6)
            )
        }
    }
}