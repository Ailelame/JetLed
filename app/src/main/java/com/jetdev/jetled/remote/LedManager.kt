package com.jetdev.jetled.remote

import timber.log.Timber

class LedManager(private val endpoint: LedEndpoint) {

    suspend fun isAlive(): Boolean {
        return try {
            val status = endpoint.ping()
            status.isNotBlank()
        } catch (e: Exception) {
            Timber.e(e)
            false
        }
    }

    suspend fun animWalking() {
        try {
            endpoint.animWalking()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

}