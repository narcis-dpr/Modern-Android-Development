package com.narcis.uistate.data

data class AuthenticationState(
    val userName: String = "",
    val password: String = "",
    val loading: Boolean = false,
    var togglePasswordVisibility: Boolean = true,
) {
    companion object {
        val EMPTY_STATE = AuthenticationState()
    }
}
