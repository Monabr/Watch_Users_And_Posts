package com.example.watchusersandposts.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address (
    var street: String,
    var suite: String,
    var city: String
) : Parcelable {

}