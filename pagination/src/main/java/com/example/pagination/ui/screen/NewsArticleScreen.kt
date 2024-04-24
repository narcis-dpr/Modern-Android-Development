package com.example.pagination.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.rememberAsyncImagePainter
import com.example.pagination.ui.viewModel.NewsArticleViewModel

@Composable
fun NewsArticleScreen() {
    val viewModel = hiltViewModel<NewsArticleViewModel>()
    val articles = viewModel.getNewsArticle().collectAsLazyPagingItems()

    LazyColumn {
        items(count = articles.itemCount) { index ->
            NewsArticleCard(
                author = articles[index]?.author ?: "",
                content = articles[index]?.content ?: "",
                title = articles[index]?.title ?: "",
                urlToImage = articles[index]?.urlToImage ?: ""
            )
        }
        when (articles.loadState.refresh) {
            is LoadState.Error -> {

            }

            LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier.fillParentMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Refresh Loading",
                            modifier = Modifier.padding(8.dp)
                        )

                        CircularProgressIndicator(color = Color.Green)
                    }
                }
            }

            is LoadState.NotLoading -> {}
        }

        when(articles.loadState.append) {
            is LoadState.Error -> { }
            LoadState.Loading -> {
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Pagination Loading")

                        CircularProgressIndicator(color = Color.Blue)
                    }
                }
            }
            is LoadState.NotLoading -> { }
        }
    }
}

@Composable
fun NewsArticleCard(
    author: String,
    content: String,
    title: String,
    urlToImage: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 12.dp, bottom = 2.dp, end = 12.dp)
            .size(180.dp)
            .clickable { },
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(60.dp)
                    .clip(CircleShape),
                painter = rememberAsyncImagePainter(model = urlToImage),
                contentDescription = "profile"
            )
            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = author, color = Color.Black)
                Text(
                    text = content, modifier = Modifier.wrapContentSize(),
                    color = Color.Black
                )
                Text(text = title, color = Color.Black)
            }
        }
    }

}