package com.quickseries.testapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eddyhugues on 2017-08-10.
 */
data class ContactInfo(val website: Array<String>?, val email: Array<String>?, val phoneNumber: Array<String>?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.createStringArray(),
            parcel.createStringArray(),
            parcel.createStringArray()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(website)
        parcel.writeStringArray(email)
        parcel.writeStringArray(phoneNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactInfo> {
        override fun createFromParcel(parcel: Parcel): ContactInfo {
            return ContactInfo(parcel)
        }

        override fun newArray(size: Int): Array<ContactInfo?> {
            return arrayOfNulls(size)
        }
    }
}