package com.example.etitips


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass for the Africa country list.
 */
class AfricaFragment : Fragment() {

    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<CountryCardAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recycler_list, container, false)

        val continentImage = rootView.findViewById<ImageView>(R.id.continentFlag)
        continentImage.setImageResource(R.drawable.map_africa)

        val africaList = ArrayList<CountryCardItem>()
        africaList.add(CountryCardItem(R.drawable.united_states_recycler, "USA (Africa)"))
        africaList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        africaList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))

        val mRecyclerView = rootView.findViewById<RecyclerView>(R.id.countriesRecycler)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this.activity)
        mAdapter = CountryCardAdapter(africaList)

        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter

        return rootView
    }


}
