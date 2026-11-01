package com.example.messenger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, email: String) {
    var searchQuery by remember { mutableStateOf("") }
    var isActive by remember {mutableStateOf(false)}
    val searchHistory = remember {mutableListOf("")}

    Column(
        modifier = Modifier
            .background(color = Color(0xFFE3DFCE))
            .fillMaxSize(),
    ){
        Text(
            text = "Сообщения",
            fontSize = 30.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFF4C050C),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, start = 20.dp),
            textAlign = TextAlign.Start
        )
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        SearchBar(
            query = searchQuery,
            onQueryChange = {searchQuery = it},
            onSearch = {
                isActive = false
                if (searchQuery.isNotEmpty() && !searchHistory.contains(searchQuery)){
                    searchHistory.add(0,searchQuery)
                }
            },
            active = isActive,
            onActiveChange = {isActive = it},
            placeholder = {Text ("Поиск по чатам и сообщениям")},
            leadingIcon = {Icon (Icons.Default.Search, contentDescription = "Поиск")},
            trailingIcon = {
                if(isActive){
                    IconButton(onClick = {
                        if (searchQuery.isNotEmpty()){
                            searchQuery = ""
                        } else{
                            isActive = false
                        }
                    }){
                        Icon(Icons.Default.Clear, contentDescription = "Очистить")
                    }
                }
            }
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            ){
                searchHistory.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable{
                                searchQuery = item
                                isActive = false
                            }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(Icons.Default.History, contentDescription = null, modifier = Modifier.padding(end = 12.dp))
                        Text(text = item)
                    }
                }
            }
        }

    }
}