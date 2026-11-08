package com.example.messenger.screens

import androidx.compose.material3.IconButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview (showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(email: String = "") {
    var searchQuery by remember { mutableStateOf("") }
    var isActive by remember {mutableStateOf(false)}
    val searchHistory = remember { mutableStateListOf<String>()}

    Column(
        modifier = Modifier
        .background(color = Color(0xFFE3DFCE))
        .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 35.dp, start = 20.dp, end = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Сообщения",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF4C050C),
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Start
            )
            IconButton( onClick = {}){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Создать",
                    tint = Color(0xFF4C050C)
                )
            }
        }
        SearchBar(
            inputField = {
                SearchBarDefaults.InputField(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    onSearch = { query ->
                        isActive = false

                        if (query.isNotBlank() && !searchHistory.contains(query)){
                            searchHistory.add(0, query)
                        }
                    },
                    expanded = isActive,
                    onExpandedChange = {isActive = it},
                    placeholder = {
                        Text("Поиск по чатам и сообщениям")
                    },
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Поиск"
                        )
                    },
                    trailingIcon = {
                        if(isActive) {
                            IconButton(onClick = {
                                if(searchQuery.isNotEmpty()){
                                    searchQuery = ""
                                }
                                else {
                                    isActive = false
                                }
                            })
                            {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Очистить"
                                )
                            }
                        }
                    }
                )
            },
            expanded = isActive,
            windowInsets = WindowInsets(top = 0.dp),
            onExpandedChange = { isActive = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            colors = SearchBarDefaults.colors(
                containerColor = Color(0xFFEAE4D5)
            )
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
                        Icon(Icons.Default.History,
                            contentDescription = null,
                            modifier = Modifier.padding(end = 12.dp))
                        Text(text = item)
                    }
                }
            }
        }

        ChatItem("Лариса Подруга с работы пршлой 2020 год ", "Крутое приложени, мне нравится, продолжай в том же духе ты молодец))", "12:12")

    }
}