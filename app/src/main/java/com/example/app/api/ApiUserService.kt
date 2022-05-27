package com.example.app.api

import com.example.app.models.UserDetailsModel
import com.example.app.models.UserResponse
import retrofit2.http.GET
//baseUrl// https://androidtutorials.herokuapp.com/
//endPoint// usersFake
interface ApiUserService {

    @GET("usersFake")
    suspend fun getUsers(): List<UserDetailsModel>

//@POST("userFake")
    //fun getUser(): UserDetailsModel
}