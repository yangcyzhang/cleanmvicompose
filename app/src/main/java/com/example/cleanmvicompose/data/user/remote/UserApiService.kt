package com.example.cleanmvicompose.data.user.remote

import com.example.cleanmvicompose.domain.user.model.User
import kotlinx.coroutines.delay

class UserApiService {
    suspend fun fetchUsers(): List<User>{
        delay(1000) // Simulated network latency
        return listOf(User(1,"Ross"),User(2,"Rachel"), User(3,"Monica"))
    }
}