package com.example.fuzzbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fuzzbuzz.qa.number1
import com.example.fuzzbuzz.qa.number2
import com.example.fuzzbuzz.qa.number3
import com.example.fuzzbuzz.qa.number4
import com.example.fuzzbuzz.qa.service.Response
import com.example.fuzzbuzz.qa.service.Service
import kotlinx.android.synthetic.main.activity_number1.*
import kotlinx.android.synthetic.main.activity_qa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa)

        val retrofit = Retrofit.Builder()
                //서버에 맞게 주소를 계속 변경해 줌
            .baseUrl("http://13.125.27.159:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Service::class.java)

        service.getObject("1")?.enqueue(object:Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val qtext = response.body()?.Q_text
                textView9.text = qtext.toString()
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }
        })

        service.getObject("2").enqueue(object:Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val qtext = response.body()?.Q_text
                textView10.text = qtext.toString()
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }
        })

        service.getObject("4").enqueue(object:Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val qtext = response.body()?.Q_text
                textView11.text = qtext.toString()
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }
        })

        service.getObject("5").enqueue(object:Callback<Response>{
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val qtext = response.body()?.Q_text
                textView12.text = qtext.toString()
            }
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("","")
            }
        })


        // textView 클릭 이벤트
        textView9.setOnClickListener{
            val text1 = Intent(this, number1::class.java)
            startActivity(text1)
        }

        textView10.setOnClickListener{
            val text1 = Intent(this, number2::class.java)
            startActivity(text1)
        }

        textView11.setOnClickListener{
            val text1 = Intent(this, number3::class.java)
            startActivity(text1)
        }

        textView12.setOnClickListener{
            val text1 = Intent(this, number4::class.java)
            startActivity(text1)
        }

    }
}