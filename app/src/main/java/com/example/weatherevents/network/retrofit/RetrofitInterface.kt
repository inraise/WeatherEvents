package com.example.weatherevents.network.retrofit

import com.example.weatherevents.model.WeatherModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    companion object {
        const val BASE_URL =
            "https://api.openweathermap.org/data/2.5/"

        val api_service: RetrofitInterface by lazy {
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(RetrofitInterface::class.java)
        }
    }

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lon: String,
        @Query("lon") lat: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherModel
}
