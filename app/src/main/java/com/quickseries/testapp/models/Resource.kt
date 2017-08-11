package com.quickseries.testapp.models

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by eddyhugues on 2017-08-10.
 */
data class Resource(val _id: String,
                    val slug: String,
                    val eid: String,
                    val title: String,
                    val description: String,
                    val category_eid: String,
                    val __v: Int,
                    val photo: String,
                    val _active: Boolean,
                    val updated_at: String,
                    val addresses: Array<Address>?,
                    val socialMedia: SocialMedia?,
                    val contactInfo: ContactInfo?) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.createTypedArray(Address),
            parcel.readParcelable(SocialMedia::class.java.classLoader),
            parcel.readParcelable(ContactInfo::class.java.classLoader))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(slug)
        parcel.writeString(eid)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(category_eid)
        parcel.writeInt(__v)
        parcel.writeString(photo)
        parcel.writeByte(if (_active) 1 else 0)
        parcel.writeString(updated_at)
        parcel.writeTypedArray(addresses, flags)
        parcel.writeParcelable(socialMedia, flags)
        parcel.writeParcelable(contactInfo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Resource> {
        override fun createFromParcel(parcel: Parcel): Resource {
            return Resource(parcel)
        }

        override fun newArray(size: Int): Array<Resource?> {
            return arrayOfNulls(size)
        }
    }
}