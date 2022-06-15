package com.example.app.activities.domain

import com.example.app.activities.data.QuoteRepository
import com.example.app.activities.data.model.QuoteModel

class GetQuotesUseCase {

    private val quoteRepository = QuoteRepository()

    //Esta fun invoke se llamara automaticamente con solo instanciar a la class GetQuotesUseCase
    suspend operator fun invoke(): List<QuoteModel>{ //nulable?
        return quoteRepository.getQuotesQR()
    }
}