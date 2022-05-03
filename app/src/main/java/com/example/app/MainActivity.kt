package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.app.adapter.CharacterAdapter
import com.example.app.api.ApiCharacterService
import com.example.app.databinding.ActivityMainBinding
import com.example.app.model.Character
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var apiCharacterService: ApiCharacterService
    private lateinit var characterAdapter: CharacterAdapter
    private var characterList = mutableListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // 1 construir el OBJETO RETROFIT donde se colocara la base de la url, definir el convertidor
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiCharacterService = retrofit.create<ApiCharacterService>(ApiCharacterService::class.java)
        // llamar al metodo que obtendra los personajes
        getCharacters()

        // 3 Adaptar al recyclerView                       // se llama al objeto "interface"
        characterAdapter = CharacterAdapter(characterList, object : CharacterAdapter.OnClick{
            // se implementa la fun al darle click
            override fun onClickItem(position: Int, model: Character) {
                //conviertiendo list a array list
                val arrayStrings = ArrayList<String>()
                arrayStrings.addAll(model.episode)

                val intent = (Intent(this@MainActivity, CharacterDetailsActivity::class.java))
                //intent.putExtra("index", position)
                intent.putExtra("name", model.name)
                intent.putExtra("image", model.image)
                intent.putStringArrayListExtra("episodes", arrayStrings)
                intent.putExtra("origin", model.origin)
                Toast.makeText(this@MainActivity, "Detalle del Personaje", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }

        })
        binding.rvCharacter.adapter = characterAdapter
    }
    // 2 METODO para obtener personajes
    private fun getCharacters() {
        lifecycleScope.launch {
            try {
                val response = apiCharacterService.getCharacter()
                characterList.addAll(response.results)
                characterAdapter.notifyDataSetChanged()
                Toast.makeText(this@MainActivity, "Lista de personajes encontrada", Toast.LENGTH_SHORT).show()
            }catch (e:Exception){
                Toast.makeText(this@MainActivity, "Algo salio mal", Toast.LENGTH_SHORT).show()
            }
        }
    }
}