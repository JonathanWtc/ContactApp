package com.example.app.activities.data.network

import com.example.app.activities.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiQuoteClient {
    @GET (".json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}