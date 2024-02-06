package com.narcis.modern.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

@Composable
fun ButtonWithIcon() {
    Button(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_10k_24),
            contentDescription = stringResource(id = R.string.shop),
            modifier = Modifier.padding(10.dp),
        )
        Text(
            text = stringResource(id = R.string.buy),
            modifier = Modifier.padding(start = 10.dp),
        )
    }
}

@Composable
fun CornerCutShapeButton() {
    Button(onClick = { /*TODO*/ }, shape = CutCornerShape(10)) {
        Text(text = stringResource(id = R.string.cornerButton))
    }
}

@Composable
fun RoundCornerShapeButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(10.dp),
    ) {
        Text(text = stringResource(id = R.string.rounded))
    }
}

@Composable
fun ElevatedButtonExample() {
    Button(
        onClick = { /*TODO*/ },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 10.dp,
            disabledElevation = 0.dp,
        ),
    ) {
        Text(text = stringResource(id = R.string.elevated))
    }
}

@Preview
@Composable
private fun Preview() {
    Column(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
//        EditTextExample()
//
//        NotOutlinedEditTextExample()
        ButtonWithIcon()
        Spacer(modifier = Modifier.height(10.dp))
        CornerCutShapeButton()
        Spacer(modifier = Modifier.height(10.dp))
        RoundCornerShapeButton()
        Spacer(modifier = Modifier.height(10.dp))
        ElevatedButtonExample()
        Spacer(modifier = Modifier.height(10.dp))
    }
}
