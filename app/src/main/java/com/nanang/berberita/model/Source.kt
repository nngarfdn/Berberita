package com.nanang.beritaaja.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(

    @field:SerializedName("name")
    var name: String? = null,
    @field:SerializedName("id")
    var id: String? = null
) :Parcelable