package com.example.cleanmvicompose.ui.user

sealed class UserIntent {
    object FetchData : UserIntent()
    object Refresh : UserIntent()
}