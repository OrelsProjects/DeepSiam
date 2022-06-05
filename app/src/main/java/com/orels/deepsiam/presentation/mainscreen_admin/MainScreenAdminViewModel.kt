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

    private fun resetState(
        isLoading: Boolean = false,
        error: APIExceptions? = null,
        isNotificationSent: Boolean = false,
        title: String = "",
        body: String = ""
    ) {
        state = state.copy(
            isLoading = isLoading,
            error = error,
            isNotificationSent = isNotificationSent,
            title = title,
            body = body
        )
    }

    fun sendNotification() {
        resetState(isLoading = true, title = state.title, body = state.body)
        viewModelScope.launch {
            try {
                val response =
                    api.sendNotification(
                        SendNotificationBody(
                            title = state.title,
                            body = state.body
                        )
                    )
                if (response.ok) {
                    resetState(isNotificationSent = true)
                }
            } catch (exception: HttpException) {
                when (exception.code()) {
                    400 -> {
                        resetState(error = APIExceptions.EmptyBodyOrTitle, title = state.title, body = state.body)
                    }
                    else -> {
                        resetState(error = APIExceptions.UnknownError, title = state.title, body = state.body)
                    }
                }
            }
        }
    }
}