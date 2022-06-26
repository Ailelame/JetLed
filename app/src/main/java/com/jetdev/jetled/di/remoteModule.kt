package com.jetdev.jetled.di

import com.jetdev.jetled.remote.LedEndpoint
import com.jetdev.jetled.remote.LedManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

val remoteModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    single {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl("http://192.168.33.1:4444")
            .client(get())
            .build()
    }

    factory { get<Retrofit>().create(LedEndpoint::class.java) }



    factory { LedManager(get()) }



}