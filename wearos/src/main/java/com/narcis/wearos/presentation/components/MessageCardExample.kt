package com.narcis.wearos.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AppCard
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text

@Composable
fun MessageCard() {
    AppCard(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
        appImage = {
            Icon(
                imageVector = Icons.Rounded.Email,
                modifier = Modifier
                    .size(24.dp)
                    .wrapContentSize(align = Alignment.Center),
                contentDescription = "icon message"
            )
        },
        onClick = { /*TODO*/ }, appName = { "this is a notification!" }, time =
        { "12:30:12" }, title = { "Mahdi" }
    ) {
        Text(text = "Hello! whats up?")
    }
}