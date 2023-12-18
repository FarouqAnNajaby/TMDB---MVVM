package com.example.movieapp.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.repository.repository.MovieRepository

class DetailViewModel (private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovie(movieId: Int) = movieRepository.getDetailMovies(movieId).asLiveData()

    fun getMovieFromLocal(movieId: Int) = movieRepository.getMovie(movieId)
}