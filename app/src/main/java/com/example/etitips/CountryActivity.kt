package com.example.etitips

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.tabs.TabLayout

class CountryActivity : AppCompatActivity() {

    private var mAdView: AdView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)

        if (mAdView == null) {
            mAdView = findViewById(R.id.adView)
            val adRequest = AdRequest.Builder().build()
            mAdView!!.loadAd(adRequest)
        }

        val urlBundle = intent.extras
        val fileUrls = urlBundle!!.get("FileUrls") as Array<String>
        val countryName = urlBundle.get("CountryName") as String

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = countryName

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

    override fun onDestroy() {
        super.onDestroy()
        mAdView = null
    }
}
