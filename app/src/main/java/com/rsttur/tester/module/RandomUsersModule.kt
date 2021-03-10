package com.rsttur.tester.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.rsttur.tester.interfaces.RandomUserApplicationScope
import com.rsttur.tester.interfaces.RandomUsersApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [OkHttpClientModule::class])
class RandomUsersModule {

    @Provides
    fun randomUserApi(retrofit: Retrofit): RandomUsersApi =
        retrofit.create(RandomUsersApi::class.java)

    @RandomUserApplicationScope
    @Provides
    fun retrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        gson: Gson
    ): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(gsonConverterFactory)
        .build()


    @Provides
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }


    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

}


