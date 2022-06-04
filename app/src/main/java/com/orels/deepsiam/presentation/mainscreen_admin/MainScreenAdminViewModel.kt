package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orels.deepsiam.data.remote.API
import com.orels.deepsiam.data.remote.dto.SendNotificationBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenAdminViewModel @Inject constructor(
    private val api: API
): ViewModel() {
    var state by mutableStateOf(MainScreenAdminState())

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setBody(body: String) {
        state = state.copy(body = body)
    }

    fun sendNotification() {
        viewModelScope.launch {
            val response = api.sendNotification(SendNotificationBody(title = state.title, body = state.body))
            if(response.ok) {
                println("Good")
            } else {
                println(response.exception)
            }
        }
    }
}