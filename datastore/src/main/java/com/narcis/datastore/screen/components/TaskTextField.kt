package com.narcis.datastore.screen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TaskTextField(
    text: String,
    onFieldChange: (String) -> Unit,
    label: @Composable (() -> Unit)? = null
) {
TextField(value = text, onValueChange = { onFieldChange(it) },
    modifier = Modifier.fillMaxWidth()
        .padding(start = 10.dp, top = 8.dp, end = 10.dp),
    label = label
    )
}