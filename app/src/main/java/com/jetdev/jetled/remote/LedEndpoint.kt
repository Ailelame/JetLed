package com.jetdev.jetled.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LedEndpoint {

    @GET("/health")
    suspend fun ping() : String

    @GET("/animations/walk-pixel")
    suspend fun animWalking() : String


}