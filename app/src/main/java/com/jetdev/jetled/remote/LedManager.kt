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


    suspend fun animWalkingFilled() {
        try {
            endpoint.animWalkingFilled()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animFill() {
        try {
            endpoint.animFill()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animFillJetdev() {
        try {
            endpoint.animFillJetdev()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animFRFlagVertical() {
        try {
            endpoint.animFRFlagVertical()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animFRFlagHorizontal() {
        try {
            endpoint.animFRFlagHorizontal()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animBEFlagHorizontal() {
        try {
            endpoint.animBEFlagHorizontal()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }

    suspend fun animITFlagHorizontal() {
        try {
            endpoint.animITFlagHorizontal()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }


    suspend fun reset() {
        try {
            endpoint.reset()
        } catch (e: Exception) {
            Timber.e(e)
        }
    }



}