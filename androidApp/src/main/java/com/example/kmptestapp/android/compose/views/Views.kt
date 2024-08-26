package com.example.kmptestapp.android.compose.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kmptestapp.android.compose.theme.MyApplicationTheme
import com.example.kmptestapp.viewmodels.LoginViewModel

// компоуз функции, как правило, выносятся в отдельные файлы
@Composable
fun LoginText(login: String, onInputChange: (String) -> Unit) {
    TextField(value = login, onValueChange = { onInputChange(it) })
}

@Composable
fun PasswordText(password: String, onInputChange: (String) -> Unit) {
    TextField(value = password, onValueChange = { onInputChange(it) })
}

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val isLoading = viewModel.isLoading.collectAsState()
    val loginState = viewModel.loginStateFlow.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // я предпочитаю когда 1 флоу в руте и дальше уже передаются только значения
        LoginText(loginState.value.login, viewModel::onUpdateLogin)
        Spacer(modifier = Modifier.height(30.dp))
        PasswordText(loginState.value.password, viewModel::onUpdatePassword)
        Spacer(modifier = Modifier.height(30.dp))

        Box {
            Button(modifier = Modifier.fillMaxWidth(), onClick = viewModel::loginClicked) {
                Text("Login")
            }
            if (isLoading.value) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterEnd), color = Color.Cyan)
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
