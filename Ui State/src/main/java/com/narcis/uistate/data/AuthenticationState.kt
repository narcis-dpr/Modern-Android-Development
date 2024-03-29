package com.narcis.uistate.data

data class AuthenticationState(
    val userName: String = "",
    val password: String = "",
    val loading: Boolean = false,
    var togglePasswordVisibility: Boolean = true,
) {
    fun isValidForm(): Boolean {
        return userName.isNotEmpty() && password.isNotEmpty()
    }
    companion object {
        val EMPTY_STATE = AuthenticationState()
    }
}
