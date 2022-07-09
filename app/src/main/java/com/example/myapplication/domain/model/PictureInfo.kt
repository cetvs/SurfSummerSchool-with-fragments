package com.example.myapplication.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pictureInfo")
data class PictureInfo(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("photoUrl")
    val photoUrl: String,
    @SerializedName("publicationDate")
    val publicationDate: Long,
)