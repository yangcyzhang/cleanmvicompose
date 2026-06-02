package com.example.cleanmvicompose.ui.user

import com.example.cleanmvicompose.domain.user.model.User

sealed class UserUiState {
    object Loading : UserUiState()
    data class Success(val data: List<User>): UserUiState()
    object Empty: UserUiState()
    data class Error(val message: String) : UserUiState()
}