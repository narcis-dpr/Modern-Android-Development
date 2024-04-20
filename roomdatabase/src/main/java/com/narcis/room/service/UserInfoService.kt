package com.narcis.room.service

import com.narcis.room.data.UserInfo
import kotlinx.coroutines.flow.Flow

interface UserInfoService {
    fun getUserInformationFromDB(): Flow<UserInfo>
    suspend fun addUserInformationInDB(userInfo: UserInfo)
}