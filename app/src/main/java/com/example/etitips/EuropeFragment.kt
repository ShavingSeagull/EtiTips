package com.example.etitips


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass for the Europe country list.
 */
class EuropeFragment : Fragment() {

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
        continentImage.setImageResource(R.drawable.map_europe)

        val europeList = ArrayList<CountryCardItem>()
        europeList.add(CountryCardItem(R.drawable.germany_recycler, "Germany", arrayOf("file:///android_asset/germany_social.html", "file:///android_asset/germany_food_drink.html", "file:///android_asset/germany_culture.html", "file:///android_asset/mexico.html")))
        europeList.add(CountryCardItem(R.drawable.netherlands_recycler, "Netherlands", arrayOf("file:///android_asset/netherlands_social.html", "file:///android_asset/netherlands_food_drink.html", "file:///android_asset/netherlands_culture.html", "file:///android_asset/netherlands_transport.html")))
        europeList.add(CountryCardItem(R.drawable.united_kingdom_recycler, "United Kingdom", arrayOf("file:///android_asset/united_kingdom_social.html", "file:///android_asset/united_kingdom_food_drink.html", "file:///android_asset/united_kingdom_culture.html", "file:///android_asset/united_kingdom_transport.html")))

        if (mRecyclerView == null) {
            mRecyclerView = mRootView!!.findViewById(R.id.countriesRecycler)
            mRecyclerView!!.setHasFixedSize(true)
        }
        if (mLayoutManager == null) {
            mLayoutManager = LinearLayoutManager(this.activity)
        }
        if (mAdapter == null) {
            mAdapter = CountryCardAdapter(
                europeList,
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
