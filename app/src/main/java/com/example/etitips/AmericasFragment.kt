package com.example.etitips


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_list.*

/**
 * A simple [Fragment] subclass for the Americas country list.
 */
class AmericasFragment : Fragment() {

    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<CountryCardAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.recycler_list, container, false)

        val continentImage = rootView.findViewById<ImageView>(R.id.continentFlag)
        continentImage.setImageResource(R.drawable.map_americas)

        val americasList = ArrayList<CountryCardItem>()
        americasList.add(CountryCardItem(R.drawable.united_states_recycler, "United States"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.canada_recycler, "Canada"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.dummy_recycler, "Dummy Nation"))
        americasList.add(CountryCardItem(R.drawable.mexico_recycler, "Mexico"))

        val mRecyclerView = rootView.findViewById<RecyclerView>(R.id.countriesRecycler)
        mRecyclerView.setHasFixedSize(true)
        mLayoutManager = LinearLayoutManager(this.activity)
        mAdapter = CountryCardAdapter(americasList)

        mRecyclerView.layoutManager = mLayoutManager
        mRecyclerView.adapter = mAdapter

        return rootView
    }
}
