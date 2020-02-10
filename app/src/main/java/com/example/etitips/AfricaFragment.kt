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
 * A simple [Fragment] subclass for the Africa country list.
 */
class AfricaFragment : Fragment() {

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
        continentImage.setImageResource(R.drawable.map_africa)

        val africaList = ArrayList<CountryCardItem>()
        africaList.add(CountryCardItem(R.drawable.egypt_recycler, "Egypt", arrayOf("file:///android_asset/countries/egypt/egypt_social.html", "file:///android_asset/countries/egypt/egypt_food_drink.html", "file:///android_asset/countries/egypt/egypt_culture.html", "file:///android_asset/countries/egypt/egypt_transport.html")))
        africaList.add(CountryCardItem(R.drawable.fuerteventura_recycler, "Fuerteventura (Spain)", arrayOf("file:///android_asset/countries/spain/spain_social.html", "file:///android_asset/countries/spain/spain_food_drink.html", "file:///android_asset/countries/spain/spain_culture.html", "file:///android_asset/countries/spain/spain_transport.html")))
        africaList.add(CountryCardItem(R.drawable.gran_canaria_recycler, "Gran Canaria (Spain)", arrayOf("file:///android_asset/countries/spain/spain_social.html", "file:///android_asset/countries/spain/spain_food_drink.html", "file:///android_asset/countries/spain/spain_culture.html", "file:///android_asset/countries/spain/spain_transport.html")))
        africaList.add(CountryCardItem(R.drawable.lanzarote_recycler, "Lanzarote (Spain)", arrayOf("file:///android_asset/countries/spain/spain_social.html", "file:///android_asset/countries/spain/spain_food_drink.html", "file:///android_asset/countries/spain/spain_culture.html", "file:///android_asset/countries/spain/spain_transport.html")))
        africaList.add(CountryCardItem(R.drawable.morocco_recycler, "Morocco", arrayOf("file:///android_asset/countries/morocco/morocco_social.html", "file:///android_asset/countries/morocco/morocco_food_drink.html", "file:///android_asset/countries/morocco/morocco_culture.html", "file:///android_asset/countries/morocco/morocco_transport.html")))
        africaList.add(CountryCardItem(R.drawable.tenerife_recycler, "Tenerife (Spain)", arrayOf("file:///android_asset/countries/spain/spain_social.html", "file:///android_asset/countries/spain/spain_food_drink.html", "file:///android_asset/countries/spain/spain_culture.html", "file:///android_asset/countries/spain/spain_transport.html")))
        africaList.add(CountryCardItem(R.drawable.tunisia_recycler, "Tunisia", arrayOf("file:///android_asset/countries/tunisia/tunisia_social.html", "file:///android_asset/countries/tunisia/tunisia_food_drink.html", "file:///android_asset/countries/tunisia/tunisia_culture.html", "file:///android_asset/countries/tunisia/tunisia_transport.html")))

        if (mRecyclerView == null) {
            mRecyclerView = mRootView!!.findViewById(R.id.countriesRecycler)
            mRecyclerView!!.setHasFixedSize(true)
        }
        if (mLayoutManager == null) {
            mLayoutManager = LinearLayoutManager(this.activity)
        }
        if (mAdapter == null) {
            mAdapter = CountryCardAdapter(
                africaList,
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
