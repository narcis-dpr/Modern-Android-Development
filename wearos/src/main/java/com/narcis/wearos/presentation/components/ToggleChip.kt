package com.narcis.wearos.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.wear.compose.material.Switch
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.ToggleChip

@Composable
fun ToggleChipWearExample() {
    var isChecked by remember {
        mutableStateOf(true)
    }

    ToggleChip(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        label = {
                Text(text = "Alert!", maxLines = 1, overflow = TextOverflow.Ellipsis)
        },
        toggleControl = {
            Switch(checked = isChecked)
        },
        )
}