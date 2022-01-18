package com.zagon102.freemealapi.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Areas (
    @Json(name = "meals")
    val meals: List<Area>
)

@JsonClass(generateAdapter = true)
data class Area(
    @Json(name = "strArea")
    val strArea: String
)