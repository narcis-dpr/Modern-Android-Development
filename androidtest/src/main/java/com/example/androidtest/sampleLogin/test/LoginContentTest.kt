package com.example.androidtest.sampleLogin.test

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidtest.MainActivity
import com.example.androidtest.sampleLogin.util.Destination
import com.example.androidtest.sampleLogin.util.TestTags.LoginContent.SIGN_IN_BUTTON
import com.example.androidtest.sampleLogin.util.TestTags.LoginContent.USERNAME_FIELD
import com.example.androidtest.ui.theme.ModernAndroidDevelopmentTheme
import com.example.androidtest.sampleLogin.login.LoginContentScreen
import org.junit.Rule
import org.junit.Test

class LoginContentTest {
    @get:Rule
    val composeRuleTest = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController
    private fun initCompose() {
        composeRuleTest.activity.setContent {
            ModernAndroidDevelopmentTheme {
                contentLoginForTest()
                launchRegisterScreenWithNavGraph()
            }
        }
    }
    private fun launchRegisterScreenWithNavGraph() {
        composeRuleTest.activity.setContent {
            ModernAndroidDevelopmentTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Destination.LoginScreen.route,
                ) {
                    composable(Destination.LoginScreen.route) {
                        LoginContentScreen(
                            onRegisterNavigateTo = {
                                navController.navigate(Destination.LoginScreen.route)
                            },
                            loginViewModel = hiltViewModel(),
                        )
                    }
//                    composable(Destination.RegisterScreen.route) {
//
//                    }
                }
            }
        }
    }

    @Test
    fun assertSignInButtonIsDisplayed() {
        initCompose()
        composeRuleTest.onNodeWithTag(SIGN_IN_BUTTON, true).assertIsDisplayed()
    }

    @Test
    fun assertUserInputFieldIsDisplayed() {
        initCompose()
        composeRuleTest.onNodeWithTag(USERNAME_FIELD, true).assertIsDisplayed()
    }
}
