package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIConfiguration {
    @POST("login")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    fun login(
        @Body stringStringHashMap: HashMap<String, String>,
    ): Call<LoginResponse>
}