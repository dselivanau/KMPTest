package com.example.kmptestapp.android.compose.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RootScreen() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
//        Image(painter = Res.drawable.root_background, contentDescription = "asd")
//        Image(painter = painterResource(id = ), contentDescription = "Image resource")
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dp(16.0F)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                Text(text = "Go to App")
            }
        }
    }
}