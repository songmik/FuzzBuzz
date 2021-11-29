package com.example.fuzzbuzz.qa.service

import com.google.gson.annotations.SerializedName

// DTO/POJO 모델 클래스 생성 -> 아웃풋을 만드는 class 생성
data class Response(

    @SerializedName("Q_text")
    val Q_text:String,

    @SerializedName("A_text")
    val A_text:String,

    @SerializedName("input_time")
    val input_time:String,

    @SerializedName("value")
    val value:String


)
