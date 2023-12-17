package com.example.repository

import com.example.repository.repository.MovieRepository
import com.example.repository.repository.network.getOkHttp
import com.example.repository.repository.network.getService
import com.example.repository.repository.remote.service.ApiService
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {
    single { getOkHttp(androidContext()) }
    single { getService<ApiService>(get()) }

    single { MovieRepository(get()) }
}