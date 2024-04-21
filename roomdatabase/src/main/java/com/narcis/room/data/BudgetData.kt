package com.narcis.room.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "budgets")
data class BudgetData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var budgetName: String = "",
    var budgetAmount: Double = 0.0,
    var expenses: String = "",
    var startDate: String = "",
    var endDate: String = "",
    var notify: Int = 0,
    var currency: String = "",
    var totalExpenses: Double
)
