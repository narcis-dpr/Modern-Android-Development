package com.narcis.wearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.TimeText
import com.narcis.wearos.ui.theme.ModernAndroidDevelopmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModernAndroidDevelopmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WearApp("Android")
                }
            }
        }
    }
}
@Composable
fun WearApp(greetingName: String) {
    ModernAndroidDevelopmentTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(androidx.wear.compose.material.MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            SampleButton()

        }
    }
}
@Composable
fun SampleButton() {
    Button(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth()) {
        Text(text = "Click me")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModernAndroidDevelopmentTheme {

    }
}