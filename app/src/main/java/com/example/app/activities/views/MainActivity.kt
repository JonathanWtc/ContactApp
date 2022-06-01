package com.example.app.activities.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.app.activities.viewmodel.QuoteViewModel
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Observar desde la activity la actualizacion y ponerta en las textView correspondiente
        quoteViewModel.quoteModelLiveData.observe(this, Observer { updateQuote ->
            binding.tvQuote.text = updateQuote.quote
            binding.tvAuthor.text = updateQuote.author
        })
        //Al darle click a la pantalla llamar a la funcion random del quoteViewModel
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

    }
}