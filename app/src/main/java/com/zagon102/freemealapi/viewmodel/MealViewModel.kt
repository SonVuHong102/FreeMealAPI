package com.zagon102.freemealapi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.model.Meals
import com.zagon102.freemealapi.network.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {
    private val _currentMeal = MutableStateFlow<Meals?>(Meals(listOf()))
    val currentMeal: StateFlow<Meals?> by lazy { _currentMeal  }

    private var prevMealId = ""

    init {
        viewModelScope.launch {
            _currentMeal.value = ApiRepository.getMealDetail(Integer.parseInt("52772"))
        }
    }

    fun getMeal(id: String) {
        if(id == prevMealId)
            return
        viewModelScope.launch {
            if (id == Constant.RANDOM_KEY)
                _currentMeal.value = ApiRepository.getRandomMeal()
            else {
                _currentMeal.value = ApiRepository.getMealDetail(Integer.parseInt(id))
                prevMealId = id
            }
        }
    }

}