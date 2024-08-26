package com.example.kmptestapp.viewmodels

// дата классы дают нам метод copy - который по своему использованию равен переприсваиванию струткур в свифте
// каждый класс, как правило, выносится в отдельный файл
data class LoginState(
    val login: String,
    val password: String
) {
    companion object {
        val EMPTY = LoginState("", "")
    }
}