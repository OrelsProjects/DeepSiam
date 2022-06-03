package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainScreenAdminViewModel @Inject constructor(): ViewModel() {
    var state by mutableStateOf(MainScreenAdminState())

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setBody(body: String) {
        state = state.copy(body = body)
    }

    fun sendNotification() {

    }
}