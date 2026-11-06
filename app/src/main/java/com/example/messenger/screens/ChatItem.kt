package com.example.messenger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ChatItem (
    name: String,
    lastMessage: String,
    time: String
) {
    val firstLetter = name.take(1).uppercase()
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ){

        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(color = Color(0xFFB6AEA0)),
            contentAlignment = Alignment.Center
        ){
            Text(text = firstLetter,
                color = Color(0xFF4C050C))
        }
        Column() {
            Text(name)
            Text(lastMessage,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
        }
        Text(time)
    }
}