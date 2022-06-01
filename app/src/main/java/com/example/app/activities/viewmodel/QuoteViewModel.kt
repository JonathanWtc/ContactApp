package com.example.app.activities.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.activities.model.QuoteModel
import com.example.app.activities.model.QuoteProvider
//Esta clase es la encargada de conectar el modelo con la vista
class QuoteViewModel : ViewModel() {
    //LiveData nos permite observar los cambios
    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote(){
        val currentQuote: QuoteModel = QuoteProvider.random()
        //avisamos a quoteModel(liveData) de los cabios
        quoteModel.postValue(currentQuote)
    }
}