package com.example.etitips


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.ref.WeakReference

/**
 * A simple [Fragment] subclass for the Asia and Oceania country list.
 */
class AsiaOceaniaFragment : Fragment() {

    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<CountryCardAdapter.ViewHolder>? = null
    private var mRootView: View? = null
    private var mRecyclerView: RecyclerView? = null
    private var mIntent: Intent? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.recycler_list, container, false)
        }

        val continentImage = mRootView!!.findViewById<ImageView>(R.id.continentFlag)
        continentImage.setImageResource(R.drawable.map_asia_oceania)

        val asiaOceaniaList = ArrayList<CountryCardItem>()
        asiaOceaniaList.add(CountryCardItem(R.drawable.australia_recycler, "Australia", arrayOf("file:///android_asset/countries/australia/australia_social.html", "file:///android_asset/countries/australia/australia_food_drink.html", "file:///android_asset/countries/australia/australia_culture.html", "file:///android_asset/countries/australia/australia_transport.html")))
        asiaOceaniaList.add(CountryCardItem(R.drawable.japan_recycler, "Japan", arrayOf("file:///android_asset/countries/japan/japan_social.html", "file:///android_asset/countries/japan/japan_food_drink.html", "file:///android_asset/countries/japan/japan_culture.html", "file:///android_asset/countries/japan/japan_transport.html")))

        if (mRecyclerView == null) {
            mRecyclerView = mRootView!!.findViewById(R.id.countriesRecycler)
            mRecyclerView!!.setHasFixedSize(true)
        }
        if (mLayoutManager == null) {
            mLayoutManager = LinearLayoutManager(this.activity)
        }
        if (mAdapter == null) {
            mAdapter = CountryCardAdapter(
                asiaOceaniaList,
                { countryItem: CountryCardItem -> countryItemClicked(countryItem) })
        }
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.adapter = mAdapter

        return mRootView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (mRootView != null) mRootView = null
        if (mRecyclerView != null) mRecyclerView = null
        if (mLayoutManager != null) mLayoutManager = null
        if (mAdapter != null) mAdapter = null
        if (mIntent != null) mIntent = null
    }

    private fun countryItemClicked(countryItem: CountryCardItem) {
        if (mIntent == null) {
            mIntent = Intent(this.activity, CountryActivity::class.java)
        }
        mIntent!!.putExtra("FileUrls", countryItem.getFileUrls())
        mIntent!!.putExtra("CountryName", countryItem.getText())
        startActivity(mIntent)
    }
}
