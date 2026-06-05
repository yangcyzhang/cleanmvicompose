package com.example.cleanmvicompose.ui.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.compose.ui.tooling.preview.Preview
import com.example.cleanmvicompose.domain.user.model.User
import com.example.cleanmvicompose.ui.theme.CleanmvicomposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(viewModel: UserViewModel = hiltViewModel()){
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.sendIntent(UserIntent.FetchData)
    }

    UserContent(state = uiState.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserContent(state: UserUiState) {
    Scaffold(topBar = { TopAppBar(title = { Text("User List") }) }) {
        padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            when(state){
                is UserUiState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                is UserUiState.Success -> {
                    LazyColumn{
                        items(state.data){ user ->
                            Text(
                                text = user.name,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
                is UserUiState.Empty -> Text(text = "No data available", modifier = Modifier.align(Alignment.Center))
                is UserUiState.Error -> Text(text = "Error：${state.message}", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserLoading() {
    CleanmvicomposeTheme {
        UserContent(state = UserUiState.Loading)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserSuccess() {
    CleanmvicomposeTheme {
        val mockUsers = listOf(
            User(1, "Ross Geller"),
            User(2, "Rachel Green"),
            User(3, "Monica Geller")
        )
        UserContent(state = UserUiState.Success(mockUsers))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserError() {
    CleanmvicomposeTheme {
        UserContent(state = UserUiState.Error("Simulated Error"))
    }
}

