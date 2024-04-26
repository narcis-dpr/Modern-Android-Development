package com.example.custompagination.pager

interface StudentPaginator<Key, Student> {
    suspend fun loadNextStudent()
    fun reset()
}