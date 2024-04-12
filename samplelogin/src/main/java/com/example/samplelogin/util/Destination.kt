package com.example.samplelogin.util

sealed class Destination (val route: String){
    object Main: Destination("main_route")
    object LoginScreen: Destination("login_screen")
    object RegisterScreen: Destination("register_screen")
}