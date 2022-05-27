package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.app.UserAdapter
import com.example.app.api.ApiUserService
import com.example.app.databinding.ActivityMainBinding
import com.example.app.models.UserDetailsModel
import com.example.app.models.UserResponse
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private lateinit var apiUserService: ApiUserService
    private val userList = mutableListOf<UserDetailsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(userList)
        binding.rvUser.adapter = userAdapter

        val retrofit:Retrofit = Retrofit.Builder()
                .baseUrl("https://androidtutorials.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        apiUserService = retrofit.create(ApiUserService::class.java)
        getUser()
    }

    private fun getUser() {
        lifecycleScope.launch {
            try {
                Toast.makeText(this@MainActivity, "buscando usuarios", Toast.LENGTH_SHORT).show()
                val response = apiUserService.getUsers()
                userList.addAll(response.)
                userAdapter.notifyDataSetChanged()

            }catch (e:Exception){
                Toast.makeText(this@MainActivity, "error de llamada", Toast.LENGTH_SHORT).show()
                Log.e("Error Api", "${e.message}")
            }
        }
    }
}