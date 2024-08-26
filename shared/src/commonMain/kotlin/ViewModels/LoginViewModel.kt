package ViewModels

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel: BaseViewModel (

) {
    //region Properties
    private val _login = MutableStateFlow("")
    val login = _login.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    //endregion

    //region Property changes
    fun onUpdateLogin(value: String) {
        _login.value = value
    }

    fun onUpdatePassword(value: String) {
        _password.value = value
    }
    //endregion

    //region Events
    fun loginClicked() {
        println("{$_login} / {$_password}")
        setLoading(!isLoading.value)
    }
    //endregion
}