package com.example.samplelogin.login

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.example.samplelogin.data.AuthenticationState
import com.example.samplelogin.util.SampleLoginDispatchers
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
            stateHandle = SavedStateHandle()
        )
    }


    @Test
    fun `test authentication state changes`() = runTest {
        loginViewModel.userNameChanged("Madona")
        loginViewModel.passwordChanged("home")
        loginViewModel.passwordVisibility(true)

        loginViewModel.state.test {
            val stateChange = awaitItem()

            Truth.assertThat(stateChange).isEqualTo(
                AuthenticationState(
                    userName = "Madona",
                    password = "home",
                    togglePasswordVisibility = true
                )
            )
        }
    }
}