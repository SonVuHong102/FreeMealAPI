package com.zagon102.freemealapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ingredients(
    @Json(name = "meals")
    val ingredients: List<Ingredient>? = null
)


@JsonClass(generateAdapter = true)
data class Ingredient (
    @Json(name = "idIngredient")
    val idIngredient: String? = null,
    @Json(name = "strIngredient")
    val strIngredient: String? = null,
    @Json(name = "strDescription")
    val strDescription: String? = null,
    @Json(name = "strType")
    val strType: String? = null
)