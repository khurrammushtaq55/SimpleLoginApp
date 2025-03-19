package com.test.bikemapapplication.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.bikemapapplication.data.ApiService
import kotlinx.coroutines.launch
import com.test.bikemapapplication.data.Error

class LoginViewModel(private val apiService: ApiService = ApiService()) : ViewModel() {
    // we can use Dependency injection here But Due to only 1 dependency we can use it directly
    // - Otherwise di will create too much boilerplate code

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginResult by mutableStateOf<String?>(null)

    fun login() {
        if (email.isBlank()) {
            loginResult = "Email cannot be empty" // should be localized to support different languages
            return
        }
        if (password.isBlank()) {
            loginResult = "Password cannot be empty" // should be localized to support different languages
            return
        }

        viewModelScope.launch {
            val response = apiService.login(email, password)
            loginResult = when {
                response.result != null -> "Login Successful"
                response.error == Error.WRONG_CREDENTIALS -> "Wrong Credentials"
                response.error == Error.INTERNAL_SERVER_ERROR -> "Internal Server Error"
                else -> "Unknown Error"
            }
        }

    }
}