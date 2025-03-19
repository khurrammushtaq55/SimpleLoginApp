package com.test.bikemapapplication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.test.bikemapapplication.data.ApiService

class LoginViewModel(private val apiService: ApiService = ApiService()) : ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginResult by mutableStateOf<String?>(null)

    fun login() {

    }
}