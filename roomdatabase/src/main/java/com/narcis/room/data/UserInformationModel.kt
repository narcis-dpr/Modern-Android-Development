package com.narcis.room.data

import androidx.room.Entity

@Entity(tableName = "user_information")
data class UserInformationModel(
    val id: Int = 0,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Int,
    val gender: String,
    val city: String,
    val profession: String
)
