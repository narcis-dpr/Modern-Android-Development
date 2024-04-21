package com.narcis.room.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "expenses")
data class ExpenseData(
    var id: Int = 0,
    var expenseName: String = "",
    var expenseType: String = "",
    var expenseAmount: Double = 0.0,
    @ColumnInfo(name = "update_at")
    var expenseDate: String = "",
    var note: String = "",
    var currency: String = "",
    @Embedded
    val tasks: Tasks
)

data class Tasks(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var description: String,
    var priority: Int,
    @ColumnInfo(name = "update_at")
    var updatedAt: Date
)
