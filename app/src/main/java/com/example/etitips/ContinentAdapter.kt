package com.example.etitips

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ContinentAdapter(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mContext = context

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return AmericasFragment()
            1 -> return EuropeFragment()
            2 -> return AsiaOceaniaFragment()
            3 -> return AfricaFragment()
            // Sets Americas as the default because it is the first tab. Should never hit the default!
            else -> return AmericasFragment()
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return mContext.getString(R.string.continent_americas)
            1 -> return mContext.getString(R.string.continent_europe)
            2 -> return mContext.getString(R.string.continent_asia_oceania)
            3 -> return mContext.getString(R.string.continent_africa)
            // Sets Americas as the default because it is the first tab. Should never hit the default!
            else -> return mContext.getString(R.string.continent_americas)
        }
    }
}