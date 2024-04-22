package com.narcis.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ExpenseItem(
//    @PrimaryKey(autoGenerate = true)
//    private var id: Int,
    val name: String,
    var type: String?,
    @PrimaryKey(autoGenerate = true)
    val imageContentId: Int,
    val colorContentId: Int
)
