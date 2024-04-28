package com.narcis.bigscreens.data

import com.narcis.bigscreens.data.CityDataSource
import com.narcis.bigscreens.data.CityRepository
import kotlinx.coroutines.flow.flow

class CityRepositoryImpl : CityRepository {

    override fun getCities() = flow {
        val cities = CityDataSource.loadCities
        emit(cities)
    }
}