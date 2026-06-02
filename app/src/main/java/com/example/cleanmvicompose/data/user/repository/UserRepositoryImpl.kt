package com.example.cleanmvicompose.data.user.repository

import com.example.cleanmvicompose.data.user.remote.UserApiService
import com.example.cleanmvicompose.domain.user.model.User
import com.example.cleanmvicompose.domain.user.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl@Inject constructor(private val apiService: UserApiService): UserRepository {
    override suspend fun getUserList(): List<User> {
        return apiService.fetchUsers()
    }
}