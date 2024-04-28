package com.narcis.bigscreens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.bigscreens.data.City
import com.narcis.bigscreens.data.CityRepository
import com.narcis.bigscreens.data.CityRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CityViewModel(
    private val repository: CityRepository = CityRepositoryImpl()
) : ViewModel() {

    private val _cities = MutableStateFlow<List<City>>(emptyList())
    val city: StateFlow<List<City>>
        get() = _cities

    fun getCities() {
        viewModelScope.launch {
            val result = repository.getCities()
            result.collect {cityList ->
                _cities.value = cityList
            }
        }
    }
}