package com.cj3dreams.data.api

import com.cj3dreams.domain.model.DataResponse
import retrofit2.Response
import retrofit2.http.GET

interface DataApi {
    @GET("service/v2/upcomingGuides/")
    suspend fun getAllData(): Response<DataResponse>
}