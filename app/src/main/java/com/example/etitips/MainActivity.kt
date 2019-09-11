package com.example.etitips

import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, position ->  dialog.dismiss()})
            .create().show()

        val prefs: SharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putBoolean("firstStart", false)
        editor.apply()
    }
}
