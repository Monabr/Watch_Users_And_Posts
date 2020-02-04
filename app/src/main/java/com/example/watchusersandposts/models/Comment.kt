package com.example.watchusersandposts.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Comment(
    var id: Int,
    var userId: Int,
    var name: String,
    var email: String,
    var body: String
) : Parcelable {
}