package com.orels.deepsiam.data.remote.repository

import com.orels.deepsiam.data.dto.Notification

interface Repository {
    suspend fun saveNotification(notification: Notification): String
}