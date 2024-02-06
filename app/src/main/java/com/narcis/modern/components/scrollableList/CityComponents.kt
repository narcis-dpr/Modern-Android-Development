package com.narcis.modern.components.scrollableList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CityApp() {
    val cities = CityDataSource().loadCities()
    CityList(cityList = cities)
}

@Composable
fun CityList(cityList: List<City>) {
    LazyColumn {
        items(cityList) { cities ->
            CityCard(cities)
        }
    }
}

@Composable
fun CityCard(city: City) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column {
            Image(
                painter = painterResource(id = city.imageResourceId),
                contentDescription = stringResource(id = city.nameResourceId),
                modifier = Modifier.fillMaxWidth().height(154.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = LocalContext.current.getString(
                    city.nameResourceId,
                ),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CityCardPreview() {
    CityApp()
}
