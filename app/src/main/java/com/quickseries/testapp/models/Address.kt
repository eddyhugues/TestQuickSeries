package com.quickseries.testapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eddyhugues on 2017-08-10.
 */
data class Address (val address1: String?,
                    val label: String?,
                    val zipCode: String?,
                    val city: String?,
                    val state: String?,
                    val country: String?,
                    var gps: Gps?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(Gps::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(address1)
        parcel.writeString(label)
        parcel.writeString(zipCode)
        parcel.writeString(city)
        parcel.writeString(state)
        parcel.writeString(country)
        parcel.writeParcelable(gps, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Address> {
        override fun createFromParcel(parcel: Parcel): Address {
            return Address(parcel)
        }

        override fun newArray(size: Int): Array<Address?> {
            return arrayOfNulls(size)
        }
    }
}