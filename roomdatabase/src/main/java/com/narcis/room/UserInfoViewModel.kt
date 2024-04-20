package com.narcis.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.narcis.room.data.UserInfo
import com.narcis.room.service.UserInfoService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel @Inject constructor(
    private val userInfoService: UserInfoService
): ViewModel() {
    fun saveUserInformationData(userInfo: UserInfo) {
        viewModelScope.launch {
            userInfoService.addUserInformationInDB(userInfo)
        }
    }
}