package com.potatolabs.tinderapro.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object FirebaseModules  {

    @Provides
    @Singleton
    fun provideAuth() = FirebaseAuth.getInstance()

}