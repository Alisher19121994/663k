package com.example.a663k.retrofit

import com.google.gson.annotations.SerializedName

data class PosterResponse(

    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("employee_name")
    val employee_name: String? = null,
    @SerializedName("employee_salary")
    val employee_salary: Int? = null,
    @SerializedName("employee_age")
    val employee_age: Int? = null,
    @SerializedName("profile_image")
    val profile_image: String? = null
)