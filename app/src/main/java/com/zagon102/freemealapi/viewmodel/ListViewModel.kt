package com.zagon102.freemealapi.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.databinding.FragmentListViewBinding
import com.zagon102.freemealapi.model.Areas
import com.zagon102.freemealapi.model.Categories
import com.zagon102.freemealapi.model.Meal
import com.zagon102.freemealapi.model.Meals
import com.zagon102.freemealapi.network.ApiRepository
import com.zagon102.freemealapi.ui.meal.StringListFragmentDirections
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel() {
    private val _listString by lazy { MutableStateFlow<List<String>>(listOf()) }
    val listString: StateFlow<List<String>> by lazy { _listString }

    lateinit var getNavDirection: (String) -> (NavDirections)

    private var prevListKey = "First Key"

    fun getList(type: String) {
        try {
            when (type) {
                prevListKey -> return
                Constant.AREA_KEY -> getAllArea()
                Constant.CATEGORY_KEY -> getAllCategory()
                Constant.INGREDIENT_KEY -> getAllIngredient()
            }
            prevListKey = type
        } catch(e: Exception) {
            // TODO: Place Placeholder and error messages
        }
    }

    private fun getAllArea() {
        viewModelScope.launch {
            val listAreas = ApiRepository.getAllArea()
            listAreas.meals?.apply {
                val list = mutableListOf<String>()
                for (i in this) {
                    i.strArea?.apply {
                        list.add(this)
                    }
                }
                _listString.value = list
            }
        }
        getNavDirection = {
            StringListFragmentDirections.actionStringListDestToPreviewItemDest(
                Constant.AREA_KEY,
                it,
                "${Constant.AREA_LABEL} : $it"
            )
        }
    }
    private fun getAllCategory() {
        viewModelScope.launch {
            val listCategories = ApiRepository.getAllCategories()
            listCategories.meals?.apply {
                val list = mutableListOf<String>()
                for (i in this) {
                    i.strCategory?.apply {
                        list.add(this)
                    }
                }
                _listString.value = list
            }
        }
        getNavDirection = {
            StringListFragmentDirections.actionStringListDestToPreviewItemDest(
                Constant.CATEGORY_KEY,
                it,
                "${Constant.CATEGORY_LABEL} : $it")
        }
    }
    private fun getAllIngredient() {
        viewModelScope.launch {
            val listIngredients = ApiRepository.getAllIngredients()
            listIngredients.meals?.apply {
                val list = mutableListOf<String>()
                for(i in this) {
                    i.strIngredient?.apply {
                        list.add(this)
                    }
                }
                _listString.value = list
            }
        }
        getNavDirection = {
            StringListFragmentDirections.actionStringListDestToPreviewItemDest(
                Constant.INGREDIENT_KEY,
                it,
                "${Constant.INGREDIENT_LABEL} : $it")
        }
    }
}