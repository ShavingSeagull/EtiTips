package com.example.etitips


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

/**
 * A simple [Fragment] subclass.
 */
class CultureFragment(url: String) : Fragment() {

    private val mUrl = url
    private var mRootView: View? = null
    private var mWebView: WebView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // This sets up the rootView to avoid memory leaks and the impossible smart cast problem
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.country_fragments, container, false)
        }
        if (mWebView == null) {
            mWebView = mRootView!!.findViewById(R.id.sectionWebView)
        }
        mWebView!!.settings.javaScriptEnabled = false
        mWebView!!.loadUrl(mUrl)

        return mRootView
    }

    /**
     * Setting the two Views back to null to ensure they aren't kept alive and thus
     * causing a memory leak.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        if (mRootView != null) mRootView = null
        if (mWebView != null) mWebView = null
    }
}