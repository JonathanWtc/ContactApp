package com.example.app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.app.UserAdapter
import com.example.app.api.ApiUserService
import com.example.app.databinding.ActivityMainBinding
import com.example.app.models.UserDetailsModel
import com.example.app.models.UserResponse
import com.example.app.retrofit.ServiceClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userAdapter: UserAdapter
    private val userList = mutableListOf<UserDetailsModel>()

    val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userAdapter = UserAdapter(userList)
        binding.rvUser.adapter = userAdapter

        viewModel.getUsers()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.userLive.observe(this) {response ->
            userList.addAll(response)
            userAdapter.notifyDataSetChanged()
        }

        viewModel.loadingLive.observe(this) { response ->
            if (response) {
                binding.progressCircular.visibility = View.VISIBLE
            } else {
                binding.progressCircular.visibility = View.GONE
            }
        }
    }
}