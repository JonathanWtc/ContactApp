package com.example.app.activities.core

//baseUrl // https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/.json
//endPoint // .json
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//se crea un objeto para poder para poder acceder al contenido
object RetrofitHelper {
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}