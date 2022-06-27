package com.jetdev.jetled.remote

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LedEndpoint {

    @GET("/health")
    suspend fun ping() : String

    @GET("/animations/walk-pixel")
    suspend fun animWalking() : String

    @GET("/animations/walk-pixel-fill")
    suspend fun animWalkingFilled() : String

    @GET("/animations/fill")
    suspend fun animFill() : String

    @GET("/animations/fill-jetdev")
    suspend fun animFillJetdev() : String

    @GET("/animations/fr-flag-vertical")
    suspend fun animFRFlagVertical() : String

    @GET("/animations/fr-flag-horizontal")
    suspend fun animFRFlagHorizontal() : String

    @GET("/animations/be-flag-horizontal")
    suspend fun animBEFlagHorizontal() : String

    @GET("/animations/it-flag-horizontal")
    suspend fun animITFlagHorizontal() : String

    @GET("/reset")
    suspend fun reset() : String


}