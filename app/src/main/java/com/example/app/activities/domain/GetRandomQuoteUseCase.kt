package com.example.app.activities.domain

import com.example.app.activities.data.model.QuoteModel
import com.example.app.activities.data.model.QuoteProvider

class GetRandomQuoteUseCase {
    //Esta fun invoke se llamara automaticamente con solo instanciar la class GetRandomQuoteUseCase
    operator fun invoke(): QuoteModel { //nulable?
        val quote = QuoteProvider.quotesList    //este UseCase recuperara el listado de quotes
       if (!quote.isNullOrEmpty()){             // y si no es nulo ni vacio
           val randomPosition = (0..quote.size - 1).random() //generara un numero random entre el tamaño de las quotes
           //val randomNumber = (quote.indices).random() //otra forma
           return quote[randomPosition] //y retornara una quote con la posicion [random]
       }
        return quote[0]
    }
}