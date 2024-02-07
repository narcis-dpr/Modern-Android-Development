package com.narcis.modern.components.circularProgressIndicator

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.narcis.modern.ui.theme.Purple700
import com.narcis.modern.ui.theme.Teal200
import com.narcis.modern.ui.theme.Teal700

@Composable
fun CircularProgressIndicator(
    tracker: Float,
    progress: Float,
) {
    val circularColors = listOf(Purple700, Teal200)
    Canvas(modifier = Modifier.size(200.dp).padding(8.dp), onDraw = {
        this.drawIntoCanvas {
            drawArc( // the base circle
                color = Teal700,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = 55f, cap = StrokeCap.Butt),
                size = Size(size.width, size.height),
            )
            drawArc( // the progress with brush
                brush = Brush.linearGradient(colors = circularColors),
                startAngle = -90f,
                sweepAngle = progress(tracker, progress),
                useCenter = false,
                style = Stroke(width = 55f, cap = StrokeCap.Round),
                size = Size(size.width, size.height),
            )
        }
    })
}

fun progress(tracker: Float, progress: Float): Float {
    val totalProgress = (progress * 100) / tracker
    return ((360 * totalProgress) / 100)
}

@Preview(showBackground = true)
@Composable
fun PreviewCircular() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(tracker = 20f, progress = 8.9f)
    }
}
