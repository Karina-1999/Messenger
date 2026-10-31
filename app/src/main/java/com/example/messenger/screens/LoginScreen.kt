package com.example.messenger.screens

import android.R.attr.text
import android.net.Uri
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController){
    var email by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")}
    var passwordVisible by remember {mutableStateOf(false)}
    var showError by remember {mutableStateOf(false)}
    var showErrorP by remember {mutableStateOf(false)}

    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@(.+)\$")

    Column(
        modifier = Modifier
            .background(color = Color(0xFFE3DFCE))
            .padding(vertical = 40.dp, horizontal = 24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Авторизация",
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4C050C)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Укажите почту на которую ранее был зарегистрирован аккаунт",
            color = Color(0xFF625B52),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {newValue ->
                email = newValue
                if(showError && newValue.isNotBlank()){
                    showError = false
                }
            },
            label = { Text("Введите email") },
            shape = CircleShape,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .align(Alignment.CenterHorizontally),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            isError = showError,
            supportingText = {
            if(showError ){
                Text(
                    text = "Укажите почту",
                    color = MaterialTheme.colorScheme.error)
            }
            }
        )
        Spacer (modifier = Modifier.height(20.dp))

        Text(
            text = "Введите пароль",
            color = Color(0xFF625B52),
            textAlign = TextAlign.Center,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {password = it
            showErrorP = it.isEmpty()},
            label = {Text("Введите пароль")},
            shape = CircleShape,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .align(Alignment.CenterHorizontally),
            singleLine = true,
            isError = showErrorP,
            supportingText = {
                if(showErrorP){
                    Text(
                        text = "Поле должно быть заполнено",
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            visualTransformation = if(passwordVisible){
                VisualTransformation.None
            }
            else{
                PasswordVisualTransformation()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if(passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = {passwordVisible = !passwordVisible}) {
                    Icon(imageVector = image, contentDescription = null)
                }
            }
        )

        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = {
            if(password.isNotBlank() && emailRegex.matches(email)){
                val encodedEmail = Uri.encode(email)
                navController.navigate("home/$encodedEmail")
            }
            else if(password.isNotBlank() && email.isEmpty()){
                showError = true
            }
            else if(emailRegex.matches(email) && password.isEmpty()){
                showErrorP = true
            }
            else{
                showError = true
                showErrorP = true
            }
        },
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