package com.nanang.beritaaja.data.model

import com.google.gson.annotations.SerializedName

data class News(
    @field:SerializedName("articles")
    var articles: List<ArticlesItem?>? = null
)


