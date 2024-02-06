package com.narcis.modern.components.scrollableList

import com.narcis.modern.R

class CityDataSource {
    fun loadCities(): List<City> {
        return listOf(
            City(1, R.string.spain, R.drawable.madrid),
            City(2, R.string.new_york, R.drawable.newyork),
            City(3, R.string.tokyo, R.drawable.tokyo),
            City(4, R.string.singapur, R.drawable.singapour),
            City(5, R.string.bernn, R.drawable.bernn),
        )
    }
}
