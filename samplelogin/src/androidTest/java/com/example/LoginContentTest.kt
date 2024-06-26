package com.example

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.samplelogin.MainActivity
import com.example.samplelogin.login.LoginContentScreen
import com.example.samplelogin.login.RegisterContentScreen
import com.example.samplelogin.ui.theme.ModernAndroidDevelopmentTheme
import com.example.samplelogin.util.Destination
import com.example.samplelogin.util.TestTags
import com.example.samplelogin.util.TestTags.LoginContent.SIGN_IN_BUTTON
import com.example.samplelogin.util.TestTags.LoginContent.USERNAME_FIELD
import org.junit.Rule
import org.junit.Test

class LoginContentTest {

    @get:Rule
    val composeRuleTest = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController

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

    @Test
    fun assertRegisterClickableButtonNavigatesToRegisterScreen() {
        initCompose()
        composeRuleTest.onNodeWithTag(TestTags.LoginContent.REGISTER_USER).performClick()

        val route = navController.currentDestination?.route
        assert(route.equals(Destination.RegisterScreen.route))

    }

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
                    startDestination = Destination.LoginScreen.route
                ) {
                    composable(Destination.LoginScreen.route) {
                        LoginContentScreen(onRegisterNavigateTo = {
                            navController.navigate(
                                Destination.RegisterScreen.route
                            )
                        }, loginViewModel = hiltViewModel())
                    }

                    composable(Destination.RegisterScreen.route) {
                        RegisterContentScreen(hiltViewModel())
                    }

                }
            }
        }
    }
}