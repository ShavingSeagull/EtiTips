package com.example.etitips

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

const val AD_UNIT_ID = "ca-app-pub-3940256099942544/1033173712"

class MainActivity : AppCompatActivity() {

    private var mInterstitialAd: InterstitialAd? = null
    private var mAdIteration: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializes Google Ads
        MobileAds.initialize(this)
        // Sets up the interstitial ad OBJECT. Doesn't build it or load it here
        if (mInterstitialAd == null) {
            mInterstitialAd = InterstitialAd(applicationContext).apply {
                adUnitId = AD_UNIT_ID
                adListener = (object : AdListener() {
                    override fun onAdClosed() {
                        buildAd()
                    }
                })
            }
        }
        // Need to call buildAd once here, otherwise it will never have chance to be called by the app!
        buildAd()

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Sets the toolbar font type and size (saved as a style)
        toolbar.setTitleTextAppearance(this, R.style.AmitaTextAppearance)

        // Finds the ViewPager, which allows tab fragments
        val viewPager = findViewById<ViewPager>(R.id.menuViewPager)

        // The continent adapter controls which continent fragment is shown
        val continentAdapter = ContinentAdapter(this, supportFragmentManager)
        viewPager.adapter = continentAdapter

        // The tab layout for the continent fragments
        val tabLayout = findViewById<TabLayout>(R.id.menuTabs)
        tabLayout.setupWithViewPager(viewPager)

        // Uses SharedPreferences to determine if the app has been started for the first time,
        // in order to display the instructional modal
        val prefs: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val firstStart: Boolean = prefs.getBoolean("firstStart", true)

        if (firstStart) {
            showInstructionDialog()
        }
    }

    override fun onResume() {
        super.onResume()
        showAd()
    }

    override fun onDestroy() {
        super.onDestroy()
        mInterstitialAd = null
    }

    // Displays the options menu in the top-right
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Sets the instructional modal to appear only on the first use of the app
    private fun showInstructionDialog() {
        AlertDialog.Builder(this)
            .setTitle("Welcome to EtiTips!")
            .setMessage("EtiTips is the go-to app for etiquette tips when travelling abroad.\n\n" +
                    "Using EtiTips couldn't be simpler! Simply select the continent your desired " +
                    "country is in by swiping left or right (or by tapping the continent directly) " +
                    "and then select the country from the list. That's it!\n\nYou can find access to " +
                    "the app settings and the option to remove ads in the top right-hand corner.\n\n" +
                    "We hope you enjoy the service!")
            // Removed DialogInterface.OnClickListener as the second argument from .setPositiveButton.
            // It appeared after the "OK" comma and before the lambda.
            .setPositiveButton("OK", { dialog, position ->  dialog.dismiss()})
            .create().show()

        val prefs: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putBoolean("firstStart", false)
        editor.apply()
    }

    private fun buildAd() {
        if (mInterstitialAd!!.isLoading != true && mInterstitialAd!!.isLoaded != true) {
            val adRequest = AdRequest.Builder().build()
            mInterstitialAd!!.loadAd(adRequest)
        }
    }

    private fun showAd() {
        if (mAdIteration % 4 == 0) {
            if (mInterstitialAd!!.isLoaded) {
                mInterstitialAd!!.show()
            }
        }
        mAdIteration += 1
    }
}
