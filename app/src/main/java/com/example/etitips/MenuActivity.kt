package com.example.etitips

//import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
//import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Sets the toolbar font type and size (saved as a style)
        toolbar.setTitleTextAppearance(this, R.style.AmitaTextAppearance)

        val menuTitle = findViewById<TextView>(R.id.menuTitle)

//        val menuLayout = findViewById<ConstraintLayout>(R.id.menuLayout)
//        val animationDrawable: AnimationDrawable = menuLayout.background as AnimationDrawable
//        animationDrawable.setEnterFadeDuration(2000)
//        animationDrawable.setExitFadeDuration(4000)
//        animationDrawable.start()
    }

    override fun onStart() {
        super.onStart()
        titleAnim()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun titleAnim() {
        val titleFlash: Animation = AnimationUtils.loadAnimation(this, R.anim.menu_title_flash)
        menuTitle.startAnimation(titleFlash)
    }
}
