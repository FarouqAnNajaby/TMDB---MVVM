package com.example.movieapp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.AuthRepository

class LoginViewModel(private val authRepository: AuthRepository,) : ViewModel() {

    fun loginWithEmail(iname: String,iemail: String, ipassword: String) =
        authRepository.loginWithEmail(iname,iemail, ipassword).asLiveData()

    fun isLoggedIn() = authRepository.isLoggedIn()
}