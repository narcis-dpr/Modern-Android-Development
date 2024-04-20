package com.narcis.room.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

private const val DEFAULT_USER_ID = 0
@Dao
interface UserInformationDao {

    @Query("SELECT * FROM user_information")
    fun getUsersInformation(): Flow<List<UserInformationModel>>

    @Query("SELECT * FROM user_information WHERE id = :userId")
    fun loadAllUserInformation(userId: Int): Flow<UserInformationModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInformation(userInformation: UserInformationModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserInformation(userInformation: UserInformationModel)

    @Delete
    suspend fun deleteUserInformation(userInformation: UserInformationModel)
}