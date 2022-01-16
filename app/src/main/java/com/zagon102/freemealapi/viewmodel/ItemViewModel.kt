package com.zagon102.freemealapi.viewmodel

import androidx.lifecycle.ViewModel
import com.zagon102.freemealapi.model.Meals
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ItemViewModel : ViewModel() {
    private val _listMeal = MutableStateFlow<Meals>(Meals(listOf()))
    val listMeal: StateFlow<Meals> = _listMeal
}