package com.example.fuzzbuzz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.amazonaws.mobile.client.*

class Aws : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aws)

        AWSMobileClient.getInstance().initialize(this, object: Callback<UserStateDetails>{
            override fun onResult(result: UserStateDetails?) = when (result?.getUserState()) {
                UserState.SIGNED_IN -> {
                    val i = Intent(this@Aws, MainActivity::class.java)
                    startActivity(i)
                }
                UserState.SIGNED_OUT -> showSignIn()
                else -> {
                    AWSMobileClient.getInstance().signOut()
                    showSignIn()
                }
            }

            override fun onError(e: java.lang.Exception?) {
                e?.printStackTrace()
            }
        })
    }

    private fun showSignIn() {
        try {
            AWSMobileClient.getInstance().showSignIn(this,
                SignInUIOptions.builder().nextActivity(MainActivity::class.java).build());
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}