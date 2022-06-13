package com.orels.deepsiam.data.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notification(
    @PrimaryKey val id: String,
    @ColumnInfo val title: String,
    @ColumnInfo val body: String,
): DTO {
    override val data: Map<String, Any>
        get() = mapOf("title" to title, "body" to body)

    fun copy(element: Notification): Notification = Notification(element.id, element.title, element.body)
}