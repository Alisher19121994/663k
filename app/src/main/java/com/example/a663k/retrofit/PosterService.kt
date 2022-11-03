package com.example.a663k.retrofit

import com.example.a663k.models.Employee
import retrofit2.Call
import retrofit2.http.*

interface PosterService {

    @Headers(
        "Content-type:application/json"
    )
    @GET("employees")
    fun getListPost(): Call<ArrayList<PosterResponse>>

    @GET("employee/1{id}")
    fun singleListPost(@Path("id") id: Int): Call<PosterResponse>

    @POST("create")
    fun postListPost(@Body employee: Employee): Call<PosterResponse>

    @PUT("update/21{id}")
    fun putListPost(@Path("id") id: Int,@Body employee: Employee): Call<PosterResponse>

    @DELETE("delete/2{id}")
    fun deleteListPost(@Path("id") id: Int):Call<PosterResponse>
}