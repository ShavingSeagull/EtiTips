package com.example.etitips

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logo = findViewById<ImageView>(R.id.logo)
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
