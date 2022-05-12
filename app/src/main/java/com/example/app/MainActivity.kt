package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.app.adapter.PokemonAdapter
import com.example.app.api.ApiPokemonService
import com.example.app.databinding.ActivityMainBinding
import com.example.app.model.Pokemon
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiPokemonService: ApiPokemonService
    private lateinit var pokemonAdapter: PokemonAdapter
    private var pokemon = mutableListOf<Pokemon>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokemonAdapter = PokemonAdapter(pokemon)
        binding.rvPokemonList.adapter = pokemonAdapter

        val retrofit:Retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiPokemonService = retrofit.create(ApiPokemonService::class.java)
        getpokemons()
    }

    private fun getpokemons() {
        lifecycleScope.launch{
            try {
                Toast.makeText(this@MainActivity, "Buscando pokemon", Toast.LENGTH_SHORT).show()
                val response = apiPokemonService.getPokemon()
                pokemon.addAll(response.results)
            }catch (e:Exception){
                Toast.makeText(this@MainActivity, "Error ${e.message}", Toast.LENGTH_SHORT).show()
                Log.e("error api","${e.message}")
            }
        }
    }
}