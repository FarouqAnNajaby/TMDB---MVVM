package com.example.repository.repository

import com.example.repository.repository.remote.Resource
import com.example.repository.repository.remote.service.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository(private val service: ApiService) {

    fun getMovies() = flow {
        emit(Resource.Loading)
        try {
            val response = service.getMovies()
            emit(Resource.Success(response.execute().body()?.results?.size))
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }.flowOn(Dispatchers.IO)
}