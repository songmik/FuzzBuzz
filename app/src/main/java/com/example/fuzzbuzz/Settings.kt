package com.example.fuzzbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.amazonaws.mobile.client.AWSMobileClient
import kotlinx.android.synthetic.main.activity_settings.*

class Settings : AppCompatActivity() {

    private lateinit var auth:AWSMobileClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        auth = AWSMobileClient.getInstance()

        textView18.text = auth.toString()

        button5.setOnClickListener{
            auth.signOut()
            val logout = Intent(this, Aws::class.java)
            startActivity(logout)
        }

        
    }



}