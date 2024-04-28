package com.narcis.bigscreens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.window.layout.FoldingFeature
import androidx.window.layout.WindowInfoTracker
import com.narcis.bigscreens.components.CityApp
import com.narcis.bigscreens.ui.theme.ModernAndroidDevelopmentTheme
import com.narcis.bigscreens.util.DevicePosture
import com.narcis.bigscreens.util.cityPosture
import com.narcis.bigscreens.util.separating
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class MainActivity : ComponentActivity() {
    private val cityViewModel: CityViewModel by viewModels()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postureStateFlow = WindowInfoTracker.getOrCreate(this).windowLayoutInfo(this)
            .flowWithLifecycle(this.lifecycle)
            .map { layoutInfo ->
                val foldingFeature = layoutInfo.displayFeatures.filterIsInstance<FoldingFeature>()
                    .firstOrNull()

                when {
                    cityPosture(foldingFeature) ->
                        DevicePosture.CityPosture(foldingFeature.bounds)

                    separating(foldingFeature) ->
                        DevicePosture.Separating(foldingFeature.bounds, foldingFeature.orientation)

                    else -> DevicePosture.NormalPosture
                }
            }
            .stateIn(
                scope = lifecycleScope,
                started = SharingStarted.Eagerly,
                initialValue = DevicePosture.NormalPosture
            )

        setContent {
            ModernAndroidDevelopmentTheme {
                val windowSize = calculateWindowSizeClass(activity = this)
                val devicePosture = postureStateFlow.collectAsState().value

                CityApp(
                    windowSizeClass = windowSize.widthSizeClass,
                    devicePosture = devicePosture,
                    cityViewModel = cityViewModel
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ModernAndroidDevelopmentTheme {

    }

}