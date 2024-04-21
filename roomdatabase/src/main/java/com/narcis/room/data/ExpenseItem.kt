package com.narcis.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ExpenseItem(
    @PrimaryKey(autoGenerate = true)
    private var _id: Int,
    val name: String,
    var type: String?,
    val imageContentId: Int,
    val colorContentId: Int
)
