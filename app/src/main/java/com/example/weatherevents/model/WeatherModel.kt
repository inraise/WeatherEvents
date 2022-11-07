package com.example.weatherevents.model

data class WeatherModel(
    val base: String = "",
    val clouds: Clouds = Clouds(),
    val cod: Int = 0,
    val dt: Long = 0,
    val main: Main = Main(),
    val name: String = "",
    val sys: Sys = Sys(),
    val visibility: Long = 0,
    val weather: List<Weather> = listOf(Weather(), Weather()),
    val wind: Wind = Wind()
)