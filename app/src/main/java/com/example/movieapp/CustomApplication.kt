package com.example.movieapp

import android.app.Application
import com.chibatching.kotpref.Kotpref
import com.chibatching.kotpref.gsonpref.gson
import com.example.repository.common.Constanta
import com.example.repository.repositoryModule
import com.google.gson.Gson
import io.realm.Realm
import io.realm.RealmConfiguration
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Kotpref.gson = Gson()

        Realm.init(this)

        val config = RealmConfiguration.Builder()
            .name(Constanta.DB_NAME)
            .schemaVersion(Constanta.DB_VERSION)
            .allowQueriesOnUiThread(true)
            .allowWritesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)

        startKoin {
            androidContext(this@CustomApplication)
            modules(listOf(viewModelModule, repositoryModule))
        }

        Kotpref.init(this)
    }
}