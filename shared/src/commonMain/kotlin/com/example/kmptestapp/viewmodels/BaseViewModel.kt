package com.example.kmptestapp.viewmodels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//как вариант, можно использовать абстрактные классы
abstract class BaseViewModel {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    protected fun setLoading(value: Boolean) {
        _isLoading.value = value
    }
}