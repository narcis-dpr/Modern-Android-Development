package com.narcis.uistate.login

import android.nfc.cardemulation.CardEmulation
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.narcis.uistate.R
import com.narcis.uistate.data.AuthenticationState
import com.narcis.uistate.login.components.LoginButton
import com.narcis.uistate.login.components.PasswordInputField
import com.narcis.uistate.login.components.UserNameField
import com.narcis.uistate.ui.theme.Purple700
import com.narcis.uistate.utiles.TestTags
import com.narcis.uistate.utiles.TestTags.LoginContent.LOGO_IMAGE


@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: AuthenticationState,
    onUserNameUpdate: (String) -> Unit,
    onPasswordUpdate: (String) -> Unit,
    onLogin: () -> Unit,
    passwordToggleVisibility: (Boolean) -> Unit,
    onRegister: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(Purple700),
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
                .background(color = Purple700)
                .weight(5.0f), elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .scrollable(scrollState, Orientation.Vertical),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                UserNameField(
                    authState = uiState,
                    onValueChanged = onUserNameUpdate
                )
                PasswordInputField(
                    authState = uiState,
                    onValueChanged = onPasswordUpdate,
                    passwordToggleVisibility = passwordToggleVisibility,
                    text = stringResource(id = R.string.password)
                )
                LoginButton(
                    isLoading = uiState.loading,
                    onLoginClicked = { onLogin.invoke() },
                    text = stringResource(id = R.string.sign_in),
                    enabled = if (uiState.isValidForm()) {
                        !uiState.loading
                    } else {
                        false
                    },
                )
                ClickableText(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .testTag(TestTags.LoginContent.REGISTER_USER),
                    text = AnnotatedString(stringResource(id = R.string.register)),
                    onClick = { onRegister.invoke() },
                    style = TextStyle(
                        color = Purple700,
                        fontSize = 16.sp
                    )
                )
            }

        }

    }
}