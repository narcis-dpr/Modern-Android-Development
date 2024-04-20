package com.narcis.room.service

import com.narcis.room.data.UserInfo
import com.narcis.room.data.UserInformationModel
import com.narcis.room.data.dao.UserInformationDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInfoServiceImpl @Inject constructor(
    private val userInformationDao: UserInformationDao
) : UserInfoService {
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getUserInformationFromDB(): Flow<UserInfo> {
        return userInformationDao.getUsersInformation().filter { information ->
            information.isNotEmpty()
        }.flatMapConcat {
            userInformationDao.loadAllUserInformation().map { userInfo ->
                UserInfo(
                    id = userInfo.id,
                    firstName = userInfo.firstName,
                    lastName = userInfo.lastName,
                    dateOfBirth = userInfo.dateOfBirth,
                    gender = userInfo.gender,
                    city = userInfo.city,
                    profession = userInfo.profession
                )
            }
        }
    }

    override suspend fun addUserInformationInDB(userInfo: UserInfo) {
        userInformationDao.insertUserInformation(
            UserInformationModel(
                firstName = userInfo.firstName,
                lastName = userInfo.lastName,
                dateOfBirth = userInfo.dateOfBirth,
                gender = userInfo.gender,
                city = userInfo.city,
                profession = userInfo.profession
            )
        )
    }
}