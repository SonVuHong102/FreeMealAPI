package com.zagon102.freemealapi.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zagon102.freemealapi.model.Categories
import com.zagon102.freemealapi.model.Meals
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("search.php")
    suspend fun getAllMealByFirstLetter(@Query ("f") letter: String) : Meals?
    @GET("search.php")
    suspend fun getMealByName(@Query ("s") name: String) : Meals?
    @GET("lookup.php")
    suspend fun getMealDetail(@Query ("i") id: String) : Meals?
    @GET("random.php")
    suspend fun getRandomMeal() : Meals?
    @GET("categories.php")
    suspend fun getMealCategories() : Categories?
    @GET("list.php?c=list")
    suspend fun getAllCategories() : Meals
    @GET("list.php?a=list")
    suspend fun getAllArea() : Meals
    @GET("list.php?i=list")
    suspend fun getAllIngredients() : Meals
    @GET("filter.php")
    suspend fun filterByCategory(@Query ("c") category: String) : Meals?
    @GET("filter.php")
    suspend fun filterByArea(@Query ("a") area: String) : Meals?
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}