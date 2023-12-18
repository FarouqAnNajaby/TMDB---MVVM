package com.example.repository.repository.local.database

import com.example.repository.repository.local.model.Movie
import io.realm.Realm
import io.realm.kotlin.where

class MovieDB {

    fun insertMovie(movie: List<Movie>?) =
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction {
                it.insertOrUpdate(movie)
            }
        }

    fun getList(): List<Movie> =
        Realm.getDefaultInstance().use { realm ->
            val list = realm.where<Movie>().findAll()
            return realm.copyFromRealm(list)
        }

    fun getSingle(movieId: Int): Movie? =
        Realm.getDefaultInstance().use { realm ->
            val movie = realm.where<Movie>()
                .equalTo("id", movieId)
                .findFirst()
            return movie?.let { realm.copyFromRealm(it) }
        }

    fun updateMovie(
        movieId: Int?,budget: Int?,overview: String?, releaseDate: String?,popularity: Double?) =
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction {
                val movie = realm.where<Movie>()
                    .equalTo("id", movieId)
                    .findFirst()
                movie?.budget = budget
                movie?.overview = overview
                movie?.releaseDate = releaseDate
                movie?.popularity= popularity
                it.insertOrUpdate(movie)
            }
        }

}