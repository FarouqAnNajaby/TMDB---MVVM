package com.example.repository.repository.remote.service
import com.example.repository.repository.remote.response.ResponseDetailMovie
import com.example.repository.repository.remote.response.ResponseMovieList
import retrofit2.http.*

interface ApiService {
    @GET("now_playing")
    suspend fun getMovies() : ResponseMovieList

    @GET("{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
    ) : ResponseDetailMovie
}