package com.example.androidtest.sampleLogin.util

sealed class Destination(val route: String) {
    object LoginScreen : Destination("login_screen")
    object RegisterScreen : Destination("register_screen")
}
