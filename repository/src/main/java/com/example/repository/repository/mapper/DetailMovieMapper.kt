package com.example.repository.repository.mapper

import com.example.repository.repository.local.model.Movie
import com.example.repository.repository.remote.response.ResponseDetailMovie

object DetailMovieMapper {

    fun toDetailMovie(response: ResponseDetailMovie): Movie {
        return Movie().apply {
            id = response.id
            posterPath = response.posterPath
            title = response.title
            adult = response.adult
            budget = response.budget
            popularity = response.popularity
            releaseDate = response.releaseDate
            overview = response.overview
        }
    }


}