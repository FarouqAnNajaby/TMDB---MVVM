package com.example.repository.repository.mapper

import com.example.repository.repository.local.model.Movie
import com.example.repository.repository.remote.response.ResponseMovieList

object MovieMapper {

    fun toMovie(response: ResponseMovieList.ResultsItem?): Movie {
        return Movie().apply {
            id = response?.id
            posterPath = response?.posterPath
            title = response?.title
            adult = response?.adult
        }
    }


    fun toMovie(responses: List<ResponseMovieList.ResultsItem?>?): List<Movie>? {
        return responses?.map { toMovie(it) }
    }

}