package com.example.fuzzbuzz.qa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fuzzbuzz.R
import com.example.fuzzbuzz.qa.service.Response
import com.example.fuzzbuzz.qa.service.Service
import kotlinx.android.synthetic.main.activity_number1.*
import kotlinx.android.synthetic.main.activity_number1.textView20
import kotlinx.android.synthetic.main.activity_number1.textView21
import kotlinx.android.synthetic.main.activity_number2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class number2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number2)

        val retrofit = Retrofit.Builder()
            //서버에 맞게 주소를 계속 변경해 줌
            .baseUrl("http://52.78.225.52:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        service.getObject("2")?.enqueue(object: Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val qtext = response.body()?.Q_text
                val atext = response.body()?.A_text

                textView23.text = qtext.toString()
                textView24.text = atext.toString()
            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }

        })
    }
}