package com.example.app.activities.ui.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.app.activities.ui.viewmodel.QuoteViewModel
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //llamando a la viewModel para recuerar las quotes
        quoteViewModel.onCreate()

        //Patron del observador atra ves de liveData
        //Observar desde la activity la actualizacion y ponerta en las textView correspondiente
        quoteViewModel.mutableLiveDataQuoteModel.observe(this, Observer { updateQuote ->
            binding.tvQuote.text = updateQuote.quote
            binding.tvAuthor.text = updateQuote.author
        })
        //Patron del observador para mostrar el progressbar
        quoteViewModel.isLoading.observe(this, Observer { loading ->
            binding.progress.isVisible = loading
        })

        //Al darle click a la pantalla llamar a la funcion random del quoteViewModel
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }
}