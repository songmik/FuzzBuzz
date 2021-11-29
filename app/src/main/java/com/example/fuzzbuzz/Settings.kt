package com.example.fuzzbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amazonaws.mobile.client.AWSMobileClient
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {

    private lateinit var auth:AWSMobileClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // ID or 닉네임이 textView에 보이기 위한 함수
        auth = AWSMobileClient.getInstance()
        textView18.text = auth.username.toString()

        // 로그아웃 버튼 생성
        button5.setOnClickListener{
            auth.signOut()
            val logout = Intent(this, Aws::class.java)
            startActivity(logout)
        }

        // 코로나 19 정보 확인 뷰페이저로 이동
        covid.setOnClickListener{
            val covid = Intent(this,Covid::class.java)
            startActivity(covid)
        }

    }

}
