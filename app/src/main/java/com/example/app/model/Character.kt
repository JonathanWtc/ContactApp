package com.example.app.model

import android.os.Parcelable
import java.io.Serializable

//Modelo de: https://rickandmortyapi.com/api/character
data class Character(
    val id: String,
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
): Serializable  //Averiguar sobre Parcelable y sus diferencias

