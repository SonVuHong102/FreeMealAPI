package com.zagon102.freemealapi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.model.*
import com.zagon102.freemealapi.network.ApiRepository
import com.zagon102.freemealapi.ui.meal.PreviewItemFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class ItemViewModel : ViewModel() {
    private val _listMeal by lazy { MutableStateFlow<Meals>(Meals(listOf())) }
    private val _listCategory by lazy {  MutableStateFlow<Categories>(Categories(listOf())) }
    private val _listIngredient by lazy { MutableStateFlow<Ingredients>(Ingredients(listOf())) }
    private val _listPreviewItem by lazy { MutableStateFlow<List<PreviewItem>>(listOf()) }
    val listPreviewItem: StateFlow<List<PreviewItem>> by lazy { _listPreviewItem }
    lateinit var getNavDirection: (String,String) -> (NavDirections)
    private var prevListKey = "First Key"
    private var prevValue = "First Value"

    fun getList(type: String, value: String) {
        try {
            if (type == prevListKey && value == prevValue)
                return
            when (type) {
                Constant.AREA_KEY -> filterByArea(value)
                Constant.INGREDIENT_KEY -> filterByIngredient(value)
                Constant.CATEGORY_KEY -> filterByCategory(value)
                Constant.MEAL_KEY -> filterByMeal(value)

            }
            prevListKey = type
            prevValue = value
        } catch(e: Exception) {
            // TODO: Place Placeholder and error messages
        }
    }

    private fun filterByArea(value: String) {
        viewModelScope.launch {
            val listMeal = ApiRepository.filterByArea(value)
            listMeal.meals?.apply {
                val list = mutableListOf<PreviewItem>()
                for(i in this) {
                    i?.apply {
                        list.add(PreviewItem(i.idMeal,i.strMealThumb?:"",i.strMeal,""))
                    }

                }
                _listPreviewItem.value= list
            }
        }
        getNavDirection = {id: String,label:String ->
            PreviewItemFragmentDirections.actionPreviewItemDestToDetailItemFragment(id,label)
        }
    }
    private fun filterByIngredient(value: String) {

    }
    private fun filterByCategory(value: String) {

    }

    private fun filterByMeal(value: String) {

    }
}