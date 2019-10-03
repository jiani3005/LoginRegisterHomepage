package com.mykotlinapplication.kotlin33

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Hotel(val name: String, val description: String, val rating: String, val price: String, val image: String): Parcelable