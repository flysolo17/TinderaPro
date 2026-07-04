package com.potatolabs.tinderapro.data.repository

import android.app.Activity


interface AuthRepository {
    suspend fun signInWithGoogle(
        activity: Activity
    ) : Result<String>

    fun signInWithFacebook() : Result<String>
}