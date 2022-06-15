package com.example.app.activities.data

import com.example.app.activities.data.model.QuoteModel
import com.example.app.activities.data.model.QuoteProvider
import com.example.app.activities.data.network.QuoteService
// esta clase es a la que se llamara para que devuelva las citas, ya sea de DB o Retrofit
class QuoteRepository {

    private val quoteService = QuoteService()

    suspend fun getQuotesQR(): List<QuoteModel> {
        //ponemos las respuesta obtenida por QuoteService en una variable
        val response = quoteService.getQuotesQS()
        //para ponerla en la lista DB de QuoteProvider
        QuoteProvider.quotesList = response
        return response

        //En una linea
        //return quoteService.getQuotes()
    }
}