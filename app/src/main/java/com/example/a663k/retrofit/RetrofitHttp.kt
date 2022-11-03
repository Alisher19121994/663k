package com.example.a663k.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHttp {

    val IS_TESTER = true
    val SERVER_DEVELOPMENT = "https://dummy.restapiexample.com/api/v1/"
    val SERVER_PRODUCTION = "https://dummy.restapiexample.com/api/v1/"


    fun server(): String {
        if (IS_TESTER) {
            return SERVER_DEVELOPMENT
        }
        return SERVER_PRODUCTION
    }

    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(server()).addConverterFactory(GsonConverterFactory.create())
            .build()



    val posterService: PosterService = retrofit.create(PosterService::class.java)
}