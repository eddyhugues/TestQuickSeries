package com.quickseries.testapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eddyhugues on 2017-08-10.
 */
data class SocialMedia (val youtubeChannel: Array<String>,
                        val twitter: Array<String>,
                        val facebook: Array<String>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.createStringArray(),
            parcel.createStringArray(),
            parcel.createStringArray()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(youtubeChannel)
        parcel.writeStringArray(twitter)
        parcel.writeStringArray(facebook)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SocialMedia> {
        override fun createFromParcel(parcel: Parcel): SocialMedia {
            return SocialMedia(parcel)
        }

        override fun newArray(size: Int): Array<SocialMedia?> {
            return arrayOfNulls(size)
        }
    }
}