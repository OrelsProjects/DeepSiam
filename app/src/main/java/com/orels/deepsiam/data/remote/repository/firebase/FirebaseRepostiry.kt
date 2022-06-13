package com.orels.deepsiam.data.remote.repository.firebase

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.orels.deepsiam.data.dto.Notification
import com.orels.deepsiam.data.remote.repository.Repository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepostiry @Inject constructor(): Repository {
    private val db = FirebaseFirestore.getInstance()
    override suspend fun saveNotification(notification: Notification): String {
        return try {
            val document = Collections.Notifications.get().document()
            document.set(notification.data).await()
            document.id
        } catch(ex: Exception) {
            ""
        }
    }

    private fun Collections.get(): CollectionReference = db.collection(value)

    private enum class Collections(val value: String) {
        Notifications("notifications"),
    }

}