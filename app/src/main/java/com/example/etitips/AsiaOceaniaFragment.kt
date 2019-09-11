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
 * A simple [Fragment] subclass for the Asia and Oceania country list.
 */
class AsiaOceaniaFragment : Fragment() {

    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<CountryCardAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recycler_list, container, false)

        val continentImage = rootView.findViewById<ImageView>(R.id.continentFlag)
        continentImage.setImageResource(R.drawable.map_asia_oceania)

        val asiaOceaniaList = ArrayList<CountryCardItem>()
        asiaOceaniaList.add(CountryCardItem(R.drawable.mexico_recycler, "Mexico (Asia)"))
        asiaOceaniaList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        asiaOceaniaList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))

        val mRecyclerView = rootView.findViewById<RecyclerView>(R.id.countriesRecycler)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this.activity)
        mAdapter = CountryCardAdapter(asiaOceaniaList)

        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter

        return rootView
    }


}
