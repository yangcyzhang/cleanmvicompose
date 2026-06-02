package com.example.cleanmvicompose.di.module

import com.example.cleanmvicompose.data.user.repository.UserRepositoryImpl
import com.example.cleanmvicompose.domain.user.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideUserRepository(impl: UserRepositoryImpl): UserRepository {
        return impl
    }
}