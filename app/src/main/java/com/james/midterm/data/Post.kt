package com.james.midterm.data

import android.os.Parcelable
import com.google.firebase.Timestamp
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post (
    val author: Author? = null,
    val title: String = "",
    val content: String = "",
    val id: String = "",
    val create_time: Timestamp? = null,
    val tag: String = ""
): Parcelable