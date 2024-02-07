package com.narcis.modern.components.accessibilty

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.narcis.modern.R

@Composable
fun ImageWithAccessibility() {
    Image(
        painter = painterResource(id = R.drawable.bernn),
        contentDescription = stringResource(id = R.string.city_images),
    )
}
