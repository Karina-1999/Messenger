package com.example.messenger.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ChatItem (
    name: String = "Пользователь",
    lastMessage: String = "Нет",
    time: String = "00:00"
) {
    val firstLetter = name.take(1).uppercase()
    Row(
        modifier = Modifier
            .background(color = Color(0xFFE3DFCE))
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically

    ){

        Box(
            modifier = Modifier
                .size(54.dp)
                .clip(CircleShape)
                .background(color = Color(0xFFB6AEA0)),
            contentAlignment = Alignment.Center
        ){
            Text(text = firstLetter,
                color = Color(0xFF4C050C),
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)

        ) {
            Text(name,
                color = Color(0xFF4C050C),
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis)
            Text(lastMessage,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
        }
        Text(time)
    }
}