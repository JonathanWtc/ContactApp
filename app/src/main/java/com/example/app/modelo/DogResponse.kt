package com.example.app.modelo

import com.google.gson.annotations.SerializedName

// este sera el modelo para tarer la informacion del API
data class DogsResponse(
    var status: String,
    //Propiedad que no permite Renombrar el campo del API con un nombre mas acorde
    @SerializedName("message") var images: List<String>
)
