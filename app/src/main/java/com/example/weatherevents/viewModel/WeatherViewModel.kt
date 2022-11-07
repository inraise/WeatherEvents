package com.example.weatherevents.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherevents.model.*
import com.example.weatherevents.network.retrofit.RetrofitInterface
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    var weather: WeatherModel by mutableStateOf(WeatherModel())
    var nameCantry = mutableStateOf("")
    init {
        getWeather()
    }

    fun getWeather(lon: Double = 59.57, lat: Double = 30.19): WeatherModel {
        viewModelScope.launch {
            try {
                val apiService = RetrofitInterface.api_service
                    .getWeather(lon.toString(), lat.toString(),
                        "846bddc7aaba499cd60058e2d06ad6e7")
                nameCantry.value = apiService.name
                weather = apiService
            } catch (e: Exception) {
                Log.d("EROOR", "error: ${e.message.toString()}")
            }
        }
        return weather
    }
}