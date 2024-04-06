package com.example.androidtest.sampleLogin.test

import androidx.compose.runtime.Composable
import com.example.androidtest.sampleLogin.LoginContent
import com.example.androidtest.sampleLogin.state.AuthenticationState

@Composable
fun contentLoginForTest(
    uiState: AuthenticationState = AuthenticationState(),
    onUsernameUpdated: (String) -> Unit = {},
    onPasswordUpdated: (String) -> Unit = {},
    onLogin: () -> Unit = {},
    passwordToggleVisibility: (Boolean) -> Unit = {},
    onRegisterNavigateTo: () -> Unit = {},
) {
    LoginContent(
        uiState = uiState,
        onUsernameUpdated = onUsernameUpdated,
        onPasswordUpdated = onPasswordUpdated,
        onLogin = onLogin,
        passwordToggleVisibility = passwordToggleVisibility,
        onRegister = onRegisterNavigateTo,
    )
}
