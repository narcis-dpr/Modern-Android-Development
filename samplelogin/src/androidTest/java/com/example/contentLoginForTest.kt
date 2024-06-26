package com.example

import androidx.compose.runtime.Composable
import com.example.samplelogin.data.AuthenticationState
import com.example.samplelogin.login.LoginContent


@Composable
fun contentLoginForTest(
    uiState: AuthenticationState = AuthenticationState(),
    onUsernameUpdated : (String) -> Unit = {},
    onPasswordUpdated :(String) -> Unit = {},
    onLogin : () -> Unit = {},
    passwordToggleVisibility: (Boolean) -> Unit = {},
    onRegisterNavigateTo: () -> Unit = {}
) {
    LoginContent(
        uiState = uiState,
        onUsernameUpdated = onUsernameUpdated,
        onPasswordUpdated = onPasswordUpdated,
        onLogin = onLogin,
        passwordToggleVisibility = passwordToggleVisibility,
        onRegister = onRegisterNavigateTo
    )
}
