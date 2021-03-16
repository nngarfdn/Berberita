package com.nanang.beritaaja.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticlesItem(

    @field:SerializedName("publishedAt")
    var publishedAt: String? = null,

    @field:SerializedName("author")
    var author: String? = null,

    @field:SerializedName("urlToImage")
    var urlToImage: String? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("source")
    var source: Source? = null,

    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("url")
    var url: String? = null,

    @field:SerializedName("content")
    var content: String? = null
) : Parcelable