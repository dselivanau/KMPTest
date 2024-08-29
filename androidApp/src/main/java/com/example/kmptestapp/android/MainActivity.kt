package com.example.kmptestapp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import com.example.kmptestapp.viewmodels.LoginViewModel
import com.example.kmptestapp.android.compose.views.RootScreen

// Файл активити должен быть максимально маленьким и простым
// обычно здесь очень много лишнего используется
class MainActivity : ComponentActivity() {

    private val viewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                RootScreen()
            }
        }
    }
}
