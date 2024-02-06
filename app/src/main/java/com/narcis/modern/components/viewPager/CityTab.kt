package com.narcis.modern.components.viewPager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.narcis.modern.ui.theme.Purple700
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CityTabCarousel(
    pages: MutableList<String> = arrayListOf(
        "spain",
        "new york",
        "tokyo",
        "switzerland",
        "singapre",
        "paris",
    ),
) {
    val context = LocalContext.current
    var pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
    ) { pages.size }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.width(IntrinsicSize.Max),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ScrollableTabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator()
            },
            edgePadding = 0.dp,
            modifier = Modifier.background(Color.White),
        ) {
            pages.forEachIndexed { index, title ->
                val isSelected = pagerState.currentPage == index

                TabHeader(
                    title,
                    isSelected,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
                    .background(Color.White),
            ) { page ->
                Text(
                    text = "Display city name: ${pages[page]}",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                    ),
                )
            }
        }
    }
}

@Composable
fun TabHeader(title: String, selected: Boolean, onClick: () -> Unit) {
    val context = LocalContext.current
    val color = if (selected) Purple700 else Color.White
    val ripple = rememberRipple(bounded = true, color = color)
    val interactionSource: MutableInteractionSource = remember {
        MutableInteractionSource()
    }

    Box(
        modifier = Modifier.selectable(
            selected = selected,
            onClick = { onClick() },
            enabled = true,
            role = Role.Tab,
//            interactionSource = interactionSource,
//            indication = ripple
        )
            .padding(top = 10.dp, bottom = 10.dp),
    ) {
        TabCarousel(title = title, isSelected = selected)
    }
}

@Composable
private fun TabCarousel(title: String, isSelected: Boolean) {
    val context = LocalContext.current
    val color = if (isSelected) Purple700 else Color.White
    val textColor = if (isSelected) Color.White else Color.Black

    Row(
        modifier = Modifier.background(color = color, shape = RoundedCornerShape(25.dp))
            .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
            .width(if (title.length < 11) 70.dp else 110.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Text(
            text = title,
            color = textColor,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDegreePlanCarousel() {
    Column {
        CityTabCarousel()
    }
}
