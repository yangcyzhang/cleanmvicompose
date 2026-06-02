package com.example.cleanmvicompose.domain.user.usecase

import com.example.cleanmvicompose.domain.user.model.User
import com.example.cleanmvicompose.domain.user.repository.UserRepository
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(private val userRepository: UserRepository){
    suspend operator fun invoke() : List<User>{
        return userRepository.getUserList()
    }
}