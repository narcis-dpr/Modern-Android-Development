package com.narcis.room

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.narcis.room.data.UserInformationModel
import com.narcis.room.data.dao.UserInformationDao
import com.narcis.room.data.dao.UserInformationDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

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

    @Test
    fun insertUserInformationReturnsTrue() = runBlocking {
        val userOne = UserInformationModel(
            id = 1,
            firstName = "Narcis",
            lastName = "papi",
            dateOfBirth = 9121990,
            gender = "Female",
            city = "Tehran",
            profession = "Android Engineer"
        )

        userInformationDao.insertUserInformation(userOne)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            userInformationDao.getUsersInformation()
                .collect {
                    assertThat(it).contains(userOne)
                    latch.countDown()
                }
        }

        latch.await()
        job.cancelAndJoin()
    }

    @Test
    fun deleteUserInformation() = runBlocking {
        val userOne = UserInformationModel(
            id = 1,
            firstName = "Michelle",
            lastName = "Smith",
            dateOfBirth = 9121990,
            gender = "Male",
            city = "New york",
            profession = "Software Engineer"
        )

        val userTwo = UserInformationModel(
            id = 2,
            firstName = "Mary",
            lastName = "Simba",
            dateOfBirth = 9121989,
            gender = "Female",
            city = "New york",
            profession = "Senior Android Engineer"
        )
        userInformationDao.insertUserInformation(userOne)
        userInformationDao.insertUserInformation(userTwo)

        userInformationDao.deleteUserInformation(userTwo)

        val latch = CountDownLatch(1)
        val job = async(Dispatchers.IO) {
            userInformationDao.loadAllUserInformation().collect {
                // assertThat(it).doesNotContain(userTwo)
                latch.countDown()
            }
        }
        withContext(Dispatchers.IO) {
            latch.await()
        }
        job.cancelAndJoin()
    }


    @After
    fun closeDatabase() {
        database.close()
    }
}