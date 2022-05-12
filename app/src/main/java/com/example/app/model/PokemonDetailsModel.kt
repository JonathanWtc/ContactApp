package com.example.app.model

// https://pokeapi.co/api/v2/pokemon/1
data class PokemonDetailsModel(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val weight: Int,
    val sprites: Sprites
)

data class Sprites(
    val front_default: String,
    val front_shiny: String
)