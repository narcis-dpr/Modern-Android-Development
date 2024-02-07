package com.narcis.modern.components.collapsingtoolbar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narcis.modern.R
import com.narcis.modern.ui.theme.Teal200
import com.narcis.modern.ui.theme.Teal700

private val height = 260.dp
private val titleToolbar = 50.dp

@Composable
fun CollapsingToolBar() {
    val scrollState: ScrollState = rememberScrollState(0)
    val headerHeight = with(LocalDensity.current) {
        height.toPx()
    }
    val toolbarHeight = with(LocalDensity.current) {
        titleToolbar.toPx()
    }
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        CollapsingHeader(scrollState, headerHeight)
        FactsAboutNewYork(scrollState)
        OurToolBar(scrollState, headerHeight, toolbarHeight)
        City()
    }
}

@Composable
fun City() {
    Text(
        text = stringResource(id = R.string.new_york),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 24.dp, top = 16.dp),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OurToolBar(scrollState: ScrollState, headerHeight: Float, toolbarHeight: Float) {
    val bottom = headerHeight - toolbarHeight
    val showToolbar by remember {
        derivedStateOf { scrollState.value >= bottom }
    }
    AnimatedVisibility(
        visible = showToolbar,
        enter = fadeIn(animationSpec = tween(200)),
        exit = fadeOut(animationSpec = tween(200)),
    ) {
        TopAppBar(
            title = { },
            modifier = Modifier.background(
                brush = Brush.horizontalGradient(
                    listOf(Teal200, Teal700),
                ),
            ),
        )
    }
}

@Composable
fun FactsAboutNewYork(scrollState: ScrollState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(scrollState),
    ) {
        Spacer(modifier = Modifier.height(height))
        repeat(5) {
            Text(
                text = stringResource(id = R.string.text),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify,
                modifier = Modifier.background(Color.Black)
                    .padding(16.dp),
            )
        }
    }
}

@Composable
fun CollapsingHeader(scrollState: ScrollState, headerHeight: Float) {
    Box(
        modifier = Modifier.fillMaxWidth().height(height)
            .graphicsLayer {
                translationY = -scrollState.value.toFloat() / 2f
                alpha = (-1f / headerHeight) * scrollState.value + 1
            },
    ) {
        Image(
            painter = painterResource(id = R.drawable.newyork),
            contentDescription = stringResource(
                id = R.string.new_york,
            ),
            contentScale = ContentScale.FillBounds,
        )
        Box(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color.Cyan),
                    startY = 1 * headerHeight / 5,
                ),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    CollapsingToolBar()
}
