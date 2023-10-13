package com.angi_sh.secondapp

import retrofit2.http.GET
import retrofit2.http.Path
import java.util.Dictionary

interface RateApi {
    @GET("latest.js")
    suspend fun getRateById(): RateStruct
}