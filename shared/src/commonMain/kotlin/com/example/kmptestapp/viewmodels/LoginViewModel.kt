// в андроид мире и кмп используются пакеты, они используются для логического разбиения кода
// сначал идет `namespace`- `com.example.kmptestapp`, затем подпакет с маленькой буквы, без дефисов, нижних подчеркиваний, без пробелов
package com.example.kmptestapp.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// по код стайлу, при объявлении класса двоеточие отделяется пробелами
class LoginViewModel : BaseViewModel() {

    // Регионы обычно не используются, к сожалению, прагма марок в котлине тоже нет :(
    //region Properties

    // Я предпочитаю брать комплексный стейт и обновлять его, чтобы было как можно меньше еммитеров, плюс тут все операции атомарные, косяков с потоками не должно быть
    private val _loginStateFlow = MutableStateFlow(LoginState.EMPTY)
    val loginStateFlow = _loginStateFlow.asStateFlow()

    // вычисляемое свойство
    private val loginState: LoginState
        get() = loginStateFlow.value

    //endregion

    //region Property changes
    fun onUpdateLogin(value: String) {
        _loginStateFlow.value = _loginStateFlow.value.copy(login = value)
    }

    fun onUpdatePassword(value: String) {
        _loginStateFlow.value = _loginStateFlow.value.copy(password = value)
    }
    //endregion

    //region Events
    fun loginClicked() {
        println("${loginState.login} / ${loginState.password}")
        setLoading(!isLoading.value)
    }
    //endregion
}