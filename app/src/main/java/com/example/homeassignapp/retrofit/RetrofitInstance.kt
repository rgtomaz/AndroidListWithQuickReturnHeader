package com.example.homeassignapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val photoData: PhotoDataApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://yuriy.me")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PhotoDataApi::class.java)
    }
}