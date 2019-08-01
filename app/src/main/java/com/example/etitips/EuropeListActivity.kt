package com.example.etitips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EuropeListActivity : AppCompatActivity() {
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<CountryCardAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_europe_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitleTextAppearance(this, R.style.AmitaTextAppearance)

        val americasList = ArrayList<CountryCardItem>()
        americasList.add(CountryCardItem(R.drawable.canada_recycler, "Canada"))
        americasList.add(CountryCardItem(R.drawable.mexico_recycler, "Mexico"))
        americasList.add(CountryCardItem(R.drawable.united_states_recycler, "United States"))

        val mRecyclerView = findViewById<RecyclerView>(R.id.europeRecycler)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this)
        mAdapter = CountryCardAdapter(americasList)

        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }
}