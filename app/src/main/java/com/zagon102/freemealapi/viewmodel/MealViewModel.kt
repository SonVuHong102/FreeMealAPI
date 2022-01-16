package com.zagon102.freemealapi.viewmodel

import androidx.lifecycle.*
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.model.Meal
import com.zagon102.freemealapi.model.Meals
import com.zagon102.freemealapi.network.ApiRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {

    private val _listMeal = MutableStateFlow<Meals?>(Meals(listOf()))
    val listMeal: Flow<Meals?> = _listMeal
    private val _listString = MutableStateFlow<List<String>?>(listOf())
    val listString: Flow<List<String>?> = _listString


    fun getList(type: String) {
        when(type) {
            Constant.AREA_KEY -> getAllArea()
        }
    }

    private fun getAllArea() {
        viewModelScope.launch {
            _listMeal.value = ApiRepository.getAllArea()
            _listMeal.value?.meals.let {
                it?.let {
                    val list = mutableListOf<String>()
                    for(i in it) {
                        i.strArea?.let {
                            list.add(i.strArea)
                        }
                    }
                    _listString.value = list
                }
            }

        }
    }
}