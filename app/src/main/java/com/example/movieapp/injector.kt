package com.example.movieapp

import com.example.movieapp.beranda.MainViewModel
import com.example.movieapp.detail.DetailViewModel
import com.example.movieapp.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get(),get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}