package com.zagon102.freemealapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagon102.freemealapi.model.Meal
import com.zagon102.freemealapi.model.Meals
import com.zagon102.freemealapi.network.Api
import com.zagon102.freemealapi.network.ApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {
//    private val _currentMeal = MutableStateFlow<Meal?>(Meal())
//    val currentMeal : StateFlow<Meal?> = _currentMeal
//
//    private val _listMeals = MutableStateFlow<Meals?>(Meals())
//    val listMeals: StateFlow<Meals?> = _listMeals

    fun getAllArea() : List<String>{
        var meals = Meals()
        viewModelScope.launch {
            meals = ApiRepository.getAllArea()
        }
        val listArea = mutableListOf<String>()
        for(i in meals.meals!!) {
            i.strArea?.let { listArea.add(it) }
        }
        return listArea
    }
}