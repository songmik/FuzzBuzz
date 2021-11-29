package com.example.fuzzbuzz

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.fuzzbuzz.qa.service.Response
import com.example.fuzzbuzz.qa.service.Service
import kotlinx.android.synthetic.main.activity_congestion.*
import kotlinx.android.synthetic.main.activity_number1.*
import kotlinx.android.synthetic.main.activity_number1.textView21
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Congestion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congestion)

        val retrofit = Retrofit.Builder()
            //서버에 맞게 주소를 계속 변경해 줌
            .baseUrl("http://3.38.98.137:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        service.getCon("concon")?.enqueue(object: Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val input_time = response.body()?.input_time
                val value = response.body()?.value

                textView2.text = value.toString()
                textView36.text = input_time.toString()

                if (value != null) {
                    if (value>= 0.0.toString() && value <=39.9.toString()){
                        textView2.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.YellowGreen))
                    }else if (value>=40.0.toString() && value>=69.9.toString()){
                        textView2.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.Gold))
                    }else{
                        textView2.setTextColor(ContextCompat.getColor(applicationContext!!, R.color.Firebrick))
                    }
                }
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }

        })

    }
}