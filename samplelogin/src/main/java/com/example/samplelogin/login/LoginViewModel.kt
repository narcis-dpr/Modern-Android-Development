package com.example.samplelogin.login

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplelogin.data.AuthenticationState
import com.example.samplelogin.util.MutableSavedState
import com.example.samplelogin.util.ProgressLoader
import com.example.samplelogin.util.SampleLoginDispatchers
import com.example.samplelogin.util.combineFlows
import com.example.samplelogin.util.stateIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    dispatchers: SampleLoginDispatchers,
    stateHandle: SavedStateHandle
) : ViewModel() {

    private val username = MutableSavedState(
        stateHandle,
        "UserName",
        defValue = ""
    )

    private val password = MutableSavedState(
        stateHandle,
        "password",
        defValue = ""
    )

    private val passwordVisibility = MutableSavedState(
        stateHandle,
        "password_key",
        defValue = false
    )

    private val loadingProgress = ProgressLoader()

    val state = combineFlows(
        username.flow,
        password.flow,
        passwordVisibility.flow,
        loadingProgress.flow
    ) { username, password, passwordToggle, isLoading ->
        AuthenticationState(
            userName = username,
            password = password,
            togglePasswordVisibility = passwordToggle,
            loading = isLoading
        )
    }.stateIn(
        coroutineScope = viewModelScope + dispatchers.main,
        initialValue = AuthenticationState.EMPTY_STATE
    )

    fun userNameChanged(userName: String) {
        username.value = userName
    }

    fun passwordChanged(updatedPassword: String) {
        password.value = updatedPassword
    }

    fun passwordVisibility(visibility: Boolean) {
        passwordVisibility.value = visibility
    }

    fun login() {
        loadingProgress.start()

    }

}