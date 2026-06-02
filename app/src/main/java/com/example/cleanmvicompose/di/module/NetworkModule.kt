package com.example.cleanmvicompose.di.module

import com.example.cleanmvicompose.data.user.remote.UserApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideUserApiService(): UserApiService{
        return UserApiService()
    }
}