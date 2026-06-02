package com.example.cleanmvicompose.domain.user.repository

import com.example.cleanmvicompose.domain.user.model.User

interface UserRepository {
    suspend fun getUserList(): List<User>
}