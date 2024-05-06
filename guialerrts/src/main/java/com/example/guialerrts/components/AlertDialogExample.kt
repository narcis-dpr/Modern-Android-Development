package com.example.guialerrts.components


import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@Composable
fun AlertDialogExample() {
    val dialog = remember {
        mutableStateOf(true)
    }
    if (dialog.value) {
        AlertDialog(
            onDismissRequest = {
                dialog.value = false
            },
            title = {
                Text(text = "Alert Dialog Title")
            },
            text = {
                Text("This is the description text for the alert dialog.")
            },
            confirmButton = {
                Button(
                    onClick = {
                    }
                ) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                    }
                ) {
                    Text("Dismiss")
                }
            },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowAlertDialog(){
    AlertDialogExample()
}