package com.example.etitips

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CountryPageAdapter(context: Context, fm: FragmentManager, urlBundle: Array<String>) : FragmentPagerAdapter(fm) {

    private val mContext = context
    private val mUrlBundle = urlBundle

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return SocialFragment(mUrlBundle[0])
            1 -> return FoodAndDrinkFragment(mUrlBundle[1])
            2 -> return CultureFragment(mUrlBundle[2])
            3 -> return TransportFragment(mUrlBundle[3])
            // Sets Social as the default because it is the first tab. Should never hit the default!
            else -> return SocialFragment(mUrlBundle[0])
        }
    }

    override fun getCount(): Int {
        return 4
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return mContext.getString(R.string.country_social)
            1 -> return mContext.getString(R.string.country_food_and_drink)
            2 -> return mContext.getString(R.string.country_culture)
            3 -> return mContext.getString(R.string.country_transport)
            // Sets Social as the default because it is the first tab. Should never hit the default!
            else -> return mContext.getString(R.string.country_social)
        }
    }
}