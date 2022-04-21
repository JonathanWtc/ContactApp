package com.example.app

import com.example.app.modelo.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET //Tipo de llamada de Retrofit
    // la llamada será mediante la url y devolverá: respuesta con el modelo que creamos DogResponse
    suspend fun getDogsByBreeds(@Url url:String):Response<DogsResponse>
}