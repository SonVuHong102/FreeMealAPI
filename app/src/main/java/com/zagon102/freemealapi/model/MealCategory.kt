package com.zagon102.freemealapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MealCategory(
    @Json(name = "categories")
    val categories: List<Category>? = null
)