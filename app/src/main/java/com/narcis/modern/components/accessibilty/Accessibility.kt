package com.narcis.modern.components.accessibilty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.narcis.modern.R

@Composable
fun ImageWithAccessibility() {
    Image(
        painter = painterResource(id = R.drawable.bernn),
        contentDescription = stringResource(id = R.string.city_images),
    )
    Text(
        text = stringResource(id = R.string.sample),
        modifier = Modifier.padding(18.dp)
            .semantics { heading() },
    )
}
