package com.example.xmlcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import com.example.xmlcompose.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.alertDialog.setContent {
            GreetingAlertDialog()
        }
    }

    @Composable
    fun GreetingAlertDialog() {
        AlertDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(onClick = {}) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                TextButton(onClick = {}) {
                    Text(text = "OK")
                }
            },
            title = { Text(text = "Hello") },
            text = { Text(text = "Hello, and thank you for being here ! ") }
        )
    }
}
