package com.example.movieapp.beranda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.AuthRepository
import com.example.repository.repository.MovieRepository

class MainViewModel(
    private val movieRepository: MovieRepository,
    private val authRepository: AuthRepository,
) : ViewModel(){

    fun getMovies() = movieRepository.getMovies().asLiveData()

    fun getMoviesFromLocal() = movieRepository.getMoviesLocal()

    fun logout() = authRepository.logout()

}