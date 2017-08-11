package com.quickseries.testapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eddyhugues on 2017-08-10.
 */
data class Gps(val latitude: Double, val longitude: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(latitude)
        parcel.writeDouble(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gps> {
        override fun createFromParcel(parcel: Parcel): Gps {
            return Gps(parcel)
        }

        override fun newArray(size: Int): Array<Gps?> {
            return arrayOfNulls(size)
        }
    }
}