package com.orels.deepsiam.presentation.mainscreen_admin

import com.orels.deepsiam.data.remote.APIExceptions

data class MainScreenAdminState (
    var title: String = "",
    var body: String = "",
    var error: APIExceptions? = null,
    var isLoading: Boolean = false,
    var isNotificationSent: Boolean = false
) {
    fun reset() {
        title = ""
        body = ""
        error = null
        isLoading = false
        isNotificationSent = false
    }
}