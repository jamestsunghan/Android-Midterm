package com.james.midterm.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Author (
    val email: String = "",
    val id: String = "",
    val name: String = ""
): Parcelable