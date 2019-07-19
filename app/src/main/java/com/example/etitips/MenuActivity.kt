package com.example.etitips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Sets the toolbar font type and size (saved as a style)
        toolbar.setTitleTextAppearance(this, R.style.AmitaTextAppearance)

//        val menuTitle = findViewById<TextView>(R.id.menuTitle)
//        val titleAmericas = findViewById<TextView>(R.id.titleAmericas)
//        val titleEurope = findViewById<TextView>(R.id.titleEurope)
//        val titleAfrica = findViewById<TextView>(R.id.titleAfrica)
//        val titleAsiaOceania = findViewById<TextView>(R.id.titleAsiaOceania)
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

        val textFade: Animation = AnimationUtils.loadAnimation(this, R.anim.menu_americas_fade)
        titleAmericas.startAnimation(textFade)
        titleEurope.startAnimation(textFade)
        titleAfrica.startAnimation(textFade)
        titleAsiaOceania.startAnimation(textFade)
    }
}
