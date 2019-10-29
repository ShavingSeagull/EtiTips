package com.example.etitips

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class CountryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        val urlBundle = intent.extras
        val fileUrls = urlBundle!!.get("FileUrls") as Array<String>

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Sets the toolbar font type and size (saved as a style)
        toolbar.setTitleTextAppearance(this, R.style.AmitaTextAppearance)

        // Finds the ViewPager, which allows tab fragments
        val viewPager = findViewById<ViewPager>(R.id.countryViewPager)

        // The country page adapter controls which section fragment is shown
        val countryPageAdapter = CountryPageAdapter(this, supportFragmentManager, fileUrls)
        viewPager.adapter = countryPageAdapter

        // The tab layout for the individual country fragments
        val tabLayout = findViewById<TabLayout>(R.id.countryMenuTabs)
        tabLayout.setupWithViewPager(viewPager)
    }

    // Displays the options menu in the top-right
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
