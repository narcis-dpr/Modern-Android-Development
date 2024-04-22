package com.narcis.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.narcis.room.data.dao.UserInformationDao
import com.narcis.room.data.dao.UserInformationDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserInformationDBTest {
    private lateinit var database: UserInformationDatabase
    private lateinit var userInformationDao: UserInformationDao

    @Before
    fun databaseCreated() {
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
            UserInformationDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        userInformationDao = database.userInformationDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }
}