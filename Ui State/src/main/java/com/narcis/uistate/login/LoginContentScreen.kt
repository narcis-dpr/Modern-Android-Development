package com.narcis.uistate.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun LoginContentScreen(
    loginViewModel: LoginViewModel,
    onRegisterNavigateTo: () -> Unit,
){
    val viewState by loginViewModel.state.collectAsState()
    LoginContent(
        uiState = viewState,
        onUserNameUpdate = loginViewModel::userNameChanged,
        onPasswordUpdate = loginViewModel::passwordChanged,
        onLogin = loginViewModel::login,
        passwordToggleVisibility = loginViewModel::passwordVisibility
    ) {

    }
}