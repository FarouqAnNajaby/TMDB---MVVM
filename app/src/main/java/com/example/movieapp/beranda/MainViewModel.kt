package com.example.movieapp.beranda

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.MovieRepository

class MainViewModel(private val movieRepository: MovieRepository) : ViewModel(){
    fun getMovies() = movieRepository.getMovies().asLiveData()
}