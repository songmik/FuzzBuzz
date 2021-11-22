package com.example.fuzzbuzz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val congestion = Intent(this, Congestion::class.java)
            startActivity(congestion)
        }

        button2.setOnClickListener {
            val graph = Intent(this, Chart::class.java)
            startActivity(graph)
        }

        button3.setOnClickListener {
            val qa = Intent(this, QA::class.java)
            startActivity(qa)
        }

        button4.setOnClickListener {
            val settings = Intent(this, Settings::class.java)
            startActivity(settings)
        }

    }
}