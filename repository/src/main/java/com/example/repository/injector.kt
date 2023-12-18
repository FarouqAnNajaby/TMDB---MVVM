package com.example.repository

import com.example.repository.repository.MovieRepository
import com.example.repository.repository.local.database.MovieDB
import com.example.repository.repository.network.getOkHttp
import com.example.repository.repository.network.getService
import com.example.repository.repository.remote.service.ApiService
import io.realm.Realm
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val repositoryModule = module {

    single { Realm.getDefaultInstance() }

    single { getOkHttp(androidContext()) }

    single { getService<ApiService>(get()) }

    single { MovieDB() }

    single { MovieRepository(get(),get()) }
}