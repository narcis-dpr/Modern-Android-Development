package com.example.samplelogin.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.samplelogin.R
import com.example.samplelogin.data.AuthenticationState
import com.example.samplelogin.login.components.LoginButton
import com.example.samplelogin.login.components.PasswordInputField
import com.example.samplelogin.login.components.UserNameField
import com.example.samplelogin.util.TestTags.LoginContent.LOGO_IMAGE

@Composable
fun RegisterContent(
    modifier: Modifier = Modifier,
    uiState: AuthenticationState,
    onUsernameUpdated: (String) -> Unit,
    onPasswordUpdated: (String) -> Unit,
    onLogin: () -> Unit,
    passwordToggleVisibility: (Boolean) -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.purple_700)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = modifier
                    .testTag(LOGO_IMAGE),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = stringResource(id = R.string.logo)
            )
        }

        Card(
            shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
            modifier = modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.purple_700))
                .weight(5.0f), elevation = 8.dp
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .scrollable(scrollState, Orientation.Vertical),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                UserNameField(authState = uiState, onValueChanged = onUsernameUpdated)
                PasswordInputField(
                    text = stringResource(id = R.string.create_password),
                    authState = uiState,
                    onValueChanged = onPasswordUpdated,
                    passwordToggleVisibility = passwordToggleVisibility
                )
                LoginButton(
                    text = stringResource(id = R.string.sign_up),
                    enabled = if (uiState.isValidForm()) {
                        !uiState.loading
                    } else {
                        false
                    },
                    onLoginClicked = {
                        onLogin.invoke()
                    },
                    isLoading = uiState.loading
                )

            }
        }
    }
}

