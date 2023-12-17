package com.example.repository.repository.remote.service
import com.example.repository.repository.remote.response.ResponseMovieList
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("now_playing")
    fun getMovies() : Call<ResponseMovieList>
}