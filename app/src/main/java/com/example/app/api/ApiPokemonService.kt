package com.example.app.api

import com.example.app.model.PokemonList
import retrofit2.http.GET

// https://pokeapi.co/api/v2/pokemon/1
interface ApiPokemonService {
    @GET("pokemon")
    suspend fun getPokemon():PokemonList
}