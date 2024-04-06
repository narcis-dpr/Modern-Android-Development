package com.example.uistate.login

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.uistate.data.AuthenticationState
import com.example.uistate.utiles.SampleLoginDispatchers
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {
    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(
            dispatchers = SampleLoginDispatchers.createTestDispatchers(UnconfinedTestDispatcher()),
            stateHandle = SavedStateHandle(),
        )
    }

    @Test
    fun `test authentication state change`() = runTest {
        loginViewModel.userNameChanged("Madona")
        loginViewModel.passwordChanged("home")
        loginViewModel.passwordVisibility(true)
        // testing flow state:
        loginViewModel.state.test {
            val stateChange = awaitItem()
            Truth.assertThat(stateChange).isEqualTo(
                AuthenticationState(
                    userName = "Madona",
                    password = "home",
                    togglePasswordVisibility = true,
                ),
            )
        }
    }
}
