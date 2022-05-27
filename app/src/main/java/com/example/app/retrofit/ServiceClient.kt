package com.example.app.retrofit

import com.example.app.api.ApiUserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceClient {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://androidtutorials.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiUserService = retrofit.create(ApiUserService::class.java)
}