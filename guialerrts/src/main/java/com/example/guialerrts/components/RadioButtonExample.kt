package com.example.guialerrts.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonExample() {
    val choices = listOf("Mangoes", "Avocado", "Oranges")
    var selectedOption by remember {
        mutableStateOf(choices[0])
    }
    Column(modifier = Modifier.fillMaxSize()) {
        choices.forEach { option ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = selectedOption == option, onClick = { selectedOption = option })
                Text(text = option, style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 6.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowRadioButton(){
    RadioButtonExample()
}