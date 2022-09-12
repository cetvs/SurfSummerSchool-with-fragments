package com.example.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PictureInfo(
    val id: Int,
    val title: String,
    val content: String,
    val photoUrl: String,
    val publicationDate: Long,
) : Parcelable