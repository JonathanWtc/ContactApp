package com.example.app.model

//Modelo de: https://rickandmortyapi.com/api/character
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val episode: List<String>,
    val origin: Origin
)

data class Origin(
    val name: String,
    val url: String
)
