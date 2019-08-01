package com.example.etitips

class CountryCardItem(imageResource: Int, text: String) {
    private var mImageResource = imageResource
    private var mText = text

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getText(): String {
        return mText
    }
}