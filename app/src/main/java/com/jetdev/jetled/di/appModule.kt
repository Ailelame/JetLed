package com.jetdev.jetled.di

import com.jetdev.jetled.screen.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        MainViewModel(get())
    }
}