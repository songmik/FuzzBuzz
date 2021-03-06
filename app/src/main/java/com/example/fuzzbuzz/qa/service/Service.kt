package com.example.fuzzbuzz.qa.service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

//
interface Service {

    @FormUrlEncoded
    @POST("/app-faq/")
    fun getObject(@Field("idx")idx : String): Call<Response>

    @FormUrlEncoded
    @POST("/app-con/")
    fun getCon(@Field("idx")idx : String): Call<Response>

}