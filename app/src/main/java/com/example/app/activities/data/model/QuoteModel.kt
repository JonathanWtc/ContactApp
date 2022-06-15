package com.example.app.activities.data.model

import com.google.gson.annotations.SerializedName

//Desde aca se va a recuperar la informacion de retrofit, etc
//Este es el modelo de datos
data class QuoteModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)
