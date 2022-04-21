package com.example.app.modelo

import com.google.gson.annotations.SerializedName

// este sera el modelo para tarer la informacion del API
data class DogsResponse(
    //Renombfamos el campo del API con un nombre mas acorde
    @SerializedName("status") var status: String,
    @SerializedName("message") var images: List<String>
)
