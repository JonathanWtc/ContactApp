package com.example.app.api

import com.example.app.model.ResultsPokemon
import retrofit2.http.GET

// https://pokeapi.co/api/v2/pokemon/1
interface ApiPokemonService {
    @GET("pokemon")
    suspend fun getPokemon():ResultsPokemon
}