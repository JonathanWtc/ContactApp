package com.example.app.activities

import android.widget.Toast
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

    private val _messageErrorLive = MutableLiveData<String>()
    val messageErrorLive: LiveData<String> get() = _messageErrorLive

    fun getUsers() {
            viewModelScope.launch {
                try {
                    _loadingLive.value = true
                    val response = ServiceClient.apiUserService.getUsers()
                    _userLive.value = response
                    _loadingLive.value = false
                }catch (e: Exception) {
                    _messageErrorLive.value = e.message
                }

            }


    }
}