package com.example.kmptestapp.android

import ViewModels.LoginViewModel
import android.os.Bundle
import android.widget.StackView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmptestapp.Greeting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmptestapp.TestViewModel1
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {

    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                LoginScreen(viewModel)
            }
        }
    }
}

@Composable
fun LoginText(login: StateFlow<String>, onInputChange: (String) -> Unit) {
    val loginState = login.collectAsState()

    TextField(value = loginState.value, onValueChange = { onInputChange(it) })
}

@Composable
fun PasswordText(password: StateFlow<String>, onInputChange: (String) -> Unit) {
    val passwordState = password.collectAsState()

    TextField(value = passwordState.value, onValueChange = { onInputChange(it) })
}

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val isLoading = viewModel.isLoading.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginText(viewModel.login, viewModel::onUpdateLogin)
        Spacer(modifier = Modifier.height(30.dp))
        PasswordText(viewModel.password, viewModel::onUpdatePassword)
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
