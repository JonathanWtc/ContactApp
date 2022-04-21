package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.adaptador.DogAdapter
import com.example.app.databinding.ActivityMainBinding
import com.example.app.modelo.DogsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>() //variable que contiene las imagenes que muestra el adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogs.setOnQueryTextListener(this)
        adapter = DogAdapter(dogImages)
        binding.rvDogs.adapter = adapter
    }
    // Instancia del objeto Retrofit que tendra la url y e convertidor para construir
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/") //Esta es la base de la url
            //agregar los convertidores, quien convertirá el GSON al modelo DogResponse
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    // funcion para buscar en la API
    private fun searchByName(query: String) {
        //Lo que este dentro de coroutine se ejecutara en un hilo independiente
        CoroutineScope(Dispatchers.IO).launch {
            //variable:Respuesta:modelo = con fun de url.crear(interface)llamada por raza
            val call: Response<DogsResponse> =
                getRetrofit().create(ApiService::class.java).getDogsByBreeds("$query/images")
            val puppies: DogsResponse? = call.body() //el body sera donde esta la respuesta
            runOnUiThread { //lo que este dentro se ejecutara en el hilo principal
                if (call.isSuccessful) { //si la llamada es exitosa, aca se encargara de pintar
                    val images: List<String> = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(this@MainActivity, "Correcto", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                }
            }
            hidenKeyboard() // llamada de la función dentro de runOnUiThread
        }
    }
    //función para esconder el teclado después de la busqueda
    private fun hidenKeyboard() {
        val imm = getSystemService(INPUT_METHOD_SERVICE)as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)
    }
    //Metodo que le das a buscar al searchView
    override fun onQueryTextSubmit(query: String?): Boolean {
        //si la consulta del usuario no es vacio ni nulo, Se llama cuando el usuario envía la consulta.
        if (!query.isNullOrEmpty()) {
            searchByName(query.toLowerCase())
        }
        return true
    }
    //Se llama cuando el usuario cambia el texto de la consulta.
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}