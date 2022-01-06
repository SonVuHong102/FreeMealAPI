package com.zagon102.freemealapi.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

private const val BASE_URL1 = "https://android-kotlin-fun-mars-server.appspot.com"

private const val BASE_URL2 = "https://jsonplaceholder.typicode.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL2)
    .build()

interface ApiService {
    @GET("search.php")
    suspend fun getAllMealByFirstLetter(@Query ("f") letter: String) : String
    @GET("search.php")
    suspend fun getMealByName(@Query ("s") name: String) : String
    @GET("lookup.php")
    suspend fun getMealDetail(@Query ("i") id: String) : String
    @GET("/posts")
    suspend fun get(): String
}

object Api {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}