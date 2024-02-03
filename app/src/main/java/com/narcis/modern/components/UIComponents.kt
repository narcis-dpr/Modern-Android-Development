package com.narcis.modern.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.narcis.modern.R

@Composable
fun EditTextExample() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = { Text(text = stringResource(id = R.string.sample)) },
        modifier = Modifier.fillMaxWidth()
            .padding(top = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
        ),
    )
}

@Composable
fun NotOutlinedEditTextExample() {
    TextField(
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = stringResource(
                    id =
                    R.string.sample,
                ),
            )
        },
        modifier = Modifier.fillMaxWidth()
            .padding(top = 8.dp, bottom = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black,
        ),
    )
}

@Preview
@Composable
private fun Preview() {
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        EditTextExample()

        NotOutlinedEditTextExample()
    }
}
