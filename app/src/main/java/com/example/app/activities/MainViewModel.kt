package com.example.app.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.models.UserDetailsModel
import com.example.app.retrofit.ServiceClient
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _userLive = MutableLiveData<List<UserDetailsModel>>()
    val userLive: LiveData<List<UserDetailsModel>> get() = _userLive

    private val _loadingLive = MutableLiveData<Boolean>()
    val loadingLive: LiveData<Boolean> get() = _loadingLive

    fun getUsers() {
        viewModelScope.launch {
            _loadingLive.value = true
            val response = ServiceClient.apiUserService.getUsers()
            _userLive.value = response
            _loadingLive.value = false

        }
    }
}