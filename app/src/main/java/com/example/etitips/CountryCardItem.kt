package com.example.etitips

//import java.io.Serializable

class CountryCardItem(imageResource: Int, text: String, fileUrls: Array<String>) {
    private var mImageResource = imageResource
    private var mText = text
    private var mFileUrls = fileUrls

    fun getImageResource(): Int {
        return mImageResource
    }

    fun getText(): String {
        return mText
    }

    fun getFileUrls(): Array<String> {
        return mFileUrls
    }
}