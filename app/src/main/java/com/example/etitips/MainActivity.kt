package com.example.etitips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logo = findViewById<ImageView>(R.id.logo)
    }

//    private fun logoAnim() {
//        val pivotX: Float = logo.width / 2.toFloat()
//        val pivotY: Float = logo.height / 2.toFloat()
//        val rotate = RotateAnimation(0F,360F, pivotX, pivotY)
//
//        rotate.duration = 3000
//        logo.startAnimation(rotate)
//    }

    private fun logoAnim() {
        val logoBounce: Animation = AnimationUtils.loadAnimation(this, R.anim.logo_bounce)
        logo.startAnimation(logoBounce)
    }

    // TRY onStart() INSTEAD. OTHERWISE THE ANIMATION RUNS EVERY TIME THE WINDOW
    // IS MINIMISED AND OPENED. GREAT FOR DEV, NOT GREAT FOR RELEASE
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            logoAnim()
        }
    }
}
