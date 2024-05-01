package com.narcis.wearos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.AutoCenteringParams
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.ScalingLazyColumn
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import androidx.wear.compose.material.items
import androidx.wear.compose.material.rememberScalingLazyListState
import androidx.wear.compose.material.scrollAway
import com.narcis.wearos.presentation.components.ChipWearExample
import com.narcis.wearos.presentation.components.MessageCard
import com.narcis.wearos.presentation.components.ToggleChipWearExample
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
    val itemList = listOf(
        "Item 1",
        "Item 2",
        "Item 3",
        "Item 4",
        "Item 5",
        "Item 6",
        "Item 7",
        "Item 8",
        "Item 9",
        "Item 10",
        "Item 11",
        "Item 12",
        "Item 13",
        "Item 14",
        "Item 15"
    )
    ModernAndroidDevelopmentTheme {
        /*
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(androidx.wear.compose.material.MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Sample2Button()
            val itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",)
            WearOSList(itemList = itemList)
            MessageCard()
            ChipWearExample()
            ToggleChipWearExample()
        }
         */

        val contentModifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
        val iconModifier = Modifier
            .size(24.dp)
            .wrapContentSize(align = Alignment.Center)

        val scalingListState = rememberScalingLazyListState()

        Scaffold(
            timeText = { TimeText(modifier = Modifier.scrollAway(scalingListState))},
            vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom)},
            positionIndicator = {
                PositionIndicator(scalingLazyListState = scalingListState)
            }

        ) {
            ScalingLazyColumn(modifier = Modifier.fillMaxSize(),
                autoCentering = AutoCenteringParams(itemIndex = 0),
                state = scalingListState
            ) {
                item { SampleButton() }
                item { Sample2Button() }
                item { MessageCard() }
                item { ChipWearExample() }
                item { ToggleChipWearExample() }
            }
        }
    }
}

@Composable
fun WearOSList(itemList: List<String>) {
    val scalingListState = rememberScalingLazyListState()
    Scaffold(
        timeText = { TimeText(modifier = Modifier.scrollAway(scalingListState)) },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) },
        positionIndicator = {
            PositionIndicator(
                scalingLazyListState = scalingListState
            )
        }
    ) {
        ScalingLazyColumn(
            modifier = Modifier.fillMaxSize(),
            autoCentering = AutoCenteringParams(itemIndex = 0),
            state = scalingListState
        ) {

            items(itemList) { item ->
                WearOSListItem(item = item)
            }
        }
    }
}
@Composable
fun WearOSListItem(item: String) {
    Text(text = item)
}

@Composable
fun SampleButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Click me")
    }
}

@Composable
fun Sample2Button() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.AccountBox, contentDescription = "account box icon",
                modifier = Modifier
                    .size(24.dp)
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModernAndroidDevelopmentTheme {

    }
}