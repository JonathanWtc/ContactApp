package com.example.app.api

import com.example.app.model.ResultCharacter
import retrofit2.http.GET

// Url de la Api: https://rickandmortyapi.com/
// Definir cada uno de los recursos que se usaran (@GET)
// Definir funciones
interface ApiCharacterService {
    @GET("character")
    suspend fun getCharacter(): ResultCharacter
}