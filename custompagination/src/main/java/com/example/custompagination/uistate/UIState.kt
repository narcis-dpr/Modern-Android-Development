package com.example.custompagination.uistate

import com.example.custompagination.data.StudentProfile


data class UIState(
    val page: Int = 0,
    val loading: Boolean = false,
    val studentProfile: List<StudentProfile> = emptyList(),
    val error: String? = null,
    val end: Boolean = false,
)