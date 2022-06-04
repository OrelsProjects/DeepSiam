package com.orels.deepsiam.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SendNotificationBody(
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
)