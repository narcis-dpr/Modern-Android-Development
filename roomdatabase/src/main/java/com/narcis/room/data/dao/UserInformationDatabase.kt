package com.narcis.room.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.narcis.room.data.UserInformationModel

@Database(entities = [UserInformationModel::class], version = 1, exportSchema = false)
abstract class UserInformationDatabase: RoomDatabase() {
    abstract fun userInformationDao(): UserInformationDao
}