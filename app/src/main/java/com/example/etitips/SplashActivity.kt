package com.example.etitips

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(2200)

                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }

    override fun onStart() {
        super.onStart()
        logoAnim()
    }

    private fun logoAnim() {
        val logoBounce: Animation = AnimationUtils.loadAnimation(this, R.anim.logo_bounce)
        logo.startAnimation(logoBounce)
    }
}
