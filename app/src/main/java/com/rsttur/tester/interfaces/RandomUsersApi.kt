package com.rsttur.tester.interfaces

import com.rsttur.tester.model.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomUsersApi {
    @GET("api")
    fun getRandomUsers(@Query("results") size: Int): Call<Example>
}