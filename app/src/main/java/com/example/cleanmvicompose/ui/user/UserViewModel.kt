package com.example.cleanmvicompose.ui.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanmvicompose.domain.user.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val getUserListUseCase: GetUserListUseCase):
    ViewModel(){

        private val _uiState = MutableStateFlow<UserUiState>(UserUiState.Loading)
        val uiState: StateFlow<UserUiState> = _uiState.asStateFlow()

    fun sendIntent(intent: UserIntent){
        viewModelScope.launch {
            when(intent){
                UserIntent.FetchData,
                UserIntent.Refresh -> fetchData()
            }
        }
    }

    private suspend fun fetchData() {
        _uiState.value = UserUiState.Loading
        runCatching { getUserListUseCase() }.onSuccess {
            _uiState.value = if (it.isEmpty()) UserUiState.Empty else UserUiState.Success(it)
        }.onFailure {
            _uiState.value = UserUiState.Error(it.message?:" Unknown error")
        }

    }
}