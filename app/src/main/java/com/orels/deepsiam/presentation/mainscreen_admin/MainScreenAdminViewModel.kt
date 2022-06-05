package com.orels.deepsiam.presentation.mainscreen_admin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orels.deepsiam.data.remote.API
import com.orels.deepsiam.data.remote.APIExceptions
import com.orels.deepsiam.data.remote.dto.SendNotificationBody
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainScreenAdminViewModel @Inject constructor(
    private val api: API
) : ViewModel() {
    var state by mutableStateOf(MainScreenAdminState())

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setBody(body: String) {
        state = state.copy(body = body)
    }

    fun sendNotification() {
        state = state.copy(isLoading = true, error = null, isNotificationSent = false)
        val title = state.title
        val body = state.body
        state.reset()
        viewModelScope.launch {
            try {
                val response =
                    api.sendNotification(
                        SendNotificationBody(
                            title = title,
                            body = body
                        )
                    )
                if (response.ok) {
                    state = state.copy(isLoading = false, isNotificationSent = true)
                }
            } catch (exception: HttpException) {
                when (exception.code()) {
                    400 -> {
                        state =
                            state.copy(error = APIExceptions.EmptyBodyOrTitle, isLoading = false)
                    }
                }
            }
        }
    }
}