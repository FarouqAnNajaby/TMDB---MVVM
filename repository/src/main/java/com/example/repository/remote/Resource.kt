package com.example.repository.remote


sealed class Resource<out T> {
    /**
     * Most used loading
     */
    object Loading : Resource<Nothing>()

    /**
     * Loading with percentage, maybe for uploading image, downloading PDF, etc.
     */
    class LoadingPercent(val percent: Double) : Resource<Nothing>() //for uploading or downloading

    /**
     * Success with data. Eg for fething list of data
     */
    class Success<T>(val data: T) : Resource<T>()

    /**
     *
     * Success without data. Eg for deleting
     */
    object SuccessNothing : Resource<Nothing>()

    /**
     * Error with message
     */
    class Error(val message: String? = null) : Resource<Nothing>()
}