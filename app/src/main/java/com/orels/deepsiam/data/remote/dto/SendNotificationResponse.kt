package com.orels.deepsiam.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SendNotificationResponse (
    @SerializedName("code") val code: Number,
    @SerializedName("ok") val ok: Boolean,
    @SerializedName("exception") val exception: Exception,
)
