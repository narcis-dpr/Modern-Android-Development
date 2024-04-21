package com.narcis.room.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.narcis.room.data.BudgetData
import com.narcis.room.data.ExpenseData
import com.narcis.room.data.ExpenseItem
import com.narcis.room.data.UserInformationModel

@Database(
    entities = [UserInformationModel::class, ExpenseItem::class,
        BudgetData::class, ExpenseData::class], version = 1, exportSchema = false
)
abstract class UserInformationDatabase : RoomDatabase() {
    abstract fun userInformationDao(): UserInformationDao
    abstract fun budgetDao(): BudgetDao
    abstract fun itemDao(): ItemDao
    abstract fun expenseDao(): ExpenseDao
}