package com.zagon102.freemealapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Category (
    @Json(name = "idCategory")
    val idCategory: String? = null,
    @Json(name = "strCategory")
    val strCategory: String? = null,
    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String? = null,
    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String? = null
)