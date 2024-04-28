package com.narcis.bigscreens.data

import com.narcis.bigscreens.data.City
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    fun getCities(): Flow<List<City>>
}

