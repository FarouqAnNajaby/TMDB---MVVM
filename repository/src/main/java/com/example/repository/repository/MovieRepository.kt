package com.example.repository.repository

import com.example.repository.repository.local.database.MovieDB
import com.example.repository.repository.mapper.DetailMovieMapper
import com.example.repository.repository.mapper.MovieMapper
import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(
    private val service: ApiService,
    private val movieDB: MovieDB,
) {

    fun getMovies() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getMovies().results
            movieDB.insertMovie(MovieMapper.toMovie(response))
            emit(Resource.SuccessNothing)
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    fun getDetailMovies(movieId: Int) = flow {
        emit(Resource.Loading)
        try {
            val response = service.getDetailMovie(movieId)
            val data = DetailMovieMapper.toDetailMovie(response)
            movieDB.updateMovie(data.id,data.budget,data.overview,data.releaseDate,data.popularity)
            emit(Resource.SuccessNothing)
        } catch (e: Exception) {
            emit(Resource.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    fun getMovie(movieId: Int) = movieDB.getSingle(movieId)

    fun getMoviesLocal() = movieDB.getList()
}