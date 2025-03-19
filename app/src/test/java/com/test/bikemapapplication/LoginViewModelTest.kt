package com.test.bikemapapplication

import com.test.bikemapapplication.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LoginViewModelTest {
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        viewModel = LoginViewModel()
    }

    @Test
    fun `when email is empty and login button is clicked, error message should be set`(): Unit = runTest {
        viewModel.email = ""
        viewModel.password = "password"

        viewModel.login()

        assertEquals("Email cannot be empty", viewModel.loginResult)
    }
}