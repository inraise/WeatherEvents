package com.example.weatherevents

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weatherevents.ui.theme.WeatherEventsTheme
import com.example.weatherevents.viewModel.LocationViewModel
import com.example.weatherevents.viewModel.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val locationViewModel: LocationViewModel by viewModels()
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherEventsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    locationViewModel.getUserLocation(this)
                    Loc(locationViewModel, weatherViewModel, this)

                    Log.e("EROOR_RET", weatherViewModel.nameCantry.value)
                }
            }
        }
    }
}


@Composable
fun Loc(
    locationViewModel: LocationViewModel,
    weatherViewModel: WeatherViewModel,
    context: Activity
) {
    val list = locationViewModel.getUserLocation(context)

    //weatherViewModel.getWeather(list[0], list[1])

    //val temp = weatherViewModel.weather.main.temp
    //val temp1 = weatherViewModel.getWeather(list[0], list[1])

    //println("result: $temp1")

    //Log.d("AAA", temp.toString())

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text(text = "lon: ${list[0]}, lat: ${list[1]}")
           // Text(text = "${weatherViewModel.weather.name}, ${weatherViewModel.weather.sys.country}")
        }
    }
}