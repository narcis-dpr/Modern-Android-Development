package com.narcis.room.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity

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
    val id: Int = 0
)
