package com.zagon102.freemealapi.network

import com.zagon102.freemealapi.model.Categories
import com.zagon102.freemealapi.model.Meals

object ApiRepository {
     suspend fun getAllMealByFirstLetter(letter: String) : Meals? {
         return Api.retrofitService.getAllMealByFirstLetter(letter)
     }
     suspend fun getMealByName(name: String) : Meals? {
         return Api.retrofitService.getMealByName(name)
     }
     suspend fun getMealDetail(id: String) : Meals? {
         return Api.retrofitService.getMealDetail(id)
     }
     suspend fun getRandomMeal() : Meals? {
         return Api.retrofitService.getRandomMeal()
     }
     suspend fun getMealCategories() : Categories? {
         return Api.retrofitService.getMealCategories()
     }
     suspend fun getAllCategories() : Meals {
         return Api.retrofitService.getAllCategories()
     }
     suspend fun getAllArea() : Meals {
         return Api.retrofitService.getAllArea()
     }
     suspend fun getAllIngredients() : Meals {
         return Api.retrofitService.getAllIngredients()
     }
     suspend fun filterByCategory(category: String) : Meals? {
         return Api.retrofitService.filterByCategory(category)
     }
     suspend fun filterByArea(area: String) : Meals? {
         return Api.retrofitService.filterByArea(area)
     }
}