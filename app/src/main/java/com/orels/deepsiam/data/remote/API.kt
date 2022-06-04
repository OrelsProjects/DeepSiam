package com.orels.deepsiam.data.remote

import com.orels.deepsiam.data.remote.dto.SendNotificationBody
import com.orels.deepsiam.data.remote.dto.SendNotificationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface API {

    @POST("notification/send")
    suspend fun sendNotification(
        @Body body: SendNotificationBody
    ): SendNotificationResponse

}