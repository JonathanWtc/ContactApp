package com.example.app.activities.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.activities.data.model.QuoteModel
import com.example.app.activities.domain.GetQuotesUseCase
import com.example.app.activities.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

//Esta clase es la encargada de conectar el modelo con la vista
class QuoteViewModel : ViewModel() {

    //mutableLiveData nos permite observar los cambios de las citas
    val mutableLiveDataQuoteModel = MutableLiveData<QuoteModel>()
    //LiveData nos permite observar el estado del progressBar (true o false)
    val isLoading = MutableLiveData<Boolean>()

    //instancias de caso de uso
    var getQuotesUseCase = GetQuotesUseCase()           //UseCase que devolvera todas las quotes
    var getRandomQuoteUseCase = GetRandomQuoteUseCase() //UseCase que devolvera una quote en random

    //Esta funcion llamara al UseCaseQuote dentro de otro hilo (coroutine) para que nos devuelvas
    // las quotes y almacene en memoria
    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true) //al iniciar llamada al servidor iniciara el progresBar

            val resultQuote = getQuotesUseCase()
            if (!resultQuote.isNullOrEmpty()){ //si el UseCase no devuelve vacio ni nulo, hacer:
                mutableLiveDataQuoteModel.postValue(resultQuote[0]) //mostrar la primera quote
                isLoading.postValue(false) //// finaliza el progresBar
            }
        }
    }
    //Funcion que llamara al GetRandomQuoteUseCase para que devuelva una quote de forma random
    //y la muestre en pantalla
    fun randomQuote(){
        //val currentQuote: QuoteModel = QuoteProvider.randomProvider()
        //avisamos a quoteModel(liveData) de los cabios
        //quoteModelLiveData.postValue(currentQuote)
        isLoading.postValue(true) // al tocar en pantalla inicia el progresBar
        val quoteRandom = getRandomQuoteUseCase()
        mutableLiveDataQuoteModel.postValue(quoteRandom)
        isLoading.postValue(false) // al mostrar cita random finaliza el progresBar
    }


}