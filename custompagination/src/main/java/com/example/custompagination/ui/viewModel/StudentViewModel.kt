package com.example.custompagination.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.custompagination.pager.StudentPaginatorImpl
import com.example.custompagination.repository.StudentRepository
import com.example.custompagination.uistate.UIState
import kotlinx.coroutines.launch

class StudentViewModel(): ViewModel() {
    var state by mutableStateOf(UIState())

    private val studentRepository = StudentRepository()
    private val ourPaginator = StudentPaginatorImpl(
        key = state.page,
        loadUpdated = {state = state.copy(loading = it)},
        request = {studentRepository.getStudents(it,24)},
        nextKey = { state.page + 1},
        error = {state = state.copy(error = it?.localizedMessage)},
        success = {student, newKey ->
            state = state.copy(
                studentProfile = state.studentProfile + student,
                page = newKey,
                end = student.isEmpty()
            )
        }
    )

    init {
        loadStudentProfile()
    }

    private fun loadStudentProfile() {
        viewModelScope.launch {
            ourPaginator.loadNextStudent()
        }
    }
}