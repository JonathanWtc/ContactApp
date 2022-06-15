package com.example.app.activities.data.network

import com.example.app.activities.core.RetrofitHelper
import com.example.app.activities.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofitHelper = RetrofitHelper.getRetrofit()

    suspend fun getQuotesQS(): List<QuoteModel> {
        //desde aca se hace la llamada desde un hilo secundario con Dispatchers
        //y devolvera la respuesta a la suspend fun getQuotesQS que luego sera llamada por class QuoteRepository
        return withContext(Dispatchers.IO) {
            val response = retrofitHelper.create(ApiQuoteClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}