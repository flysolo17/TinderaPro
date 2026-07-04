package com.potatolabs.tinderapro.di

import android.content.Context
import androidx.credentials.CredentialManager
import com.potatolabs.tinderapro.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Named
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideContext(
        @ApplicationContext context: Context
    ) : Context = context

    @Provides
    @Singleton
    fun provideCredentialManager(
        context: Context
    ): CredentialManager = CredentialManager.create(context)




}