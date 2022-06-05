package com.orels.deepsiam.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SendNotificationResponse (
    @SerializedName("ok") val ok: Boolean,
    @SerializedName("exception") val exception: String,
)
