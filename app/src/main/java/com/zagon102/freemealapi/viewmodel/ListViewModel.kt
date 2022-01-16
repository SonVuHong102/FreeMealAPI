package com.zagon102.freemealapi.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.NavDirections
import androidx.navigation.NavGraph
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.databinding.FragmentListViewBinding
import com.zagon102.freemealapi.model.Meal
import com.zagon102.freemealapi.model.Meals
import com.zagon102.freemealapi.network.ApiRepository
import com.zagon102.freemealapi.ui.meal.StringListFragmentDirections
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.Exception

class ListViewModel : ViewModel() {

    private val _listMeal = MutableStateFlow<Meals>(Meals(listOf()))
    private val _listString = MutableStateFlow<List<String>>(listOf())
    val listString: StateFlow<List<String>> = _listString

    lateinit var getNavDirection: (String) -> (NavDirections)

    private var prevListKey = "First Key"

    fun getList(type: String) {
        when(type) {
            prevListKey -> return
            Constant.AREA_KEY -> getAllArea()
            Constant.CATEGORY_KEY -> getAllCategory()
        }
        prevListKey = type
    }

    private fun getAllArea() {
        try {
            viewModelScope.launch {
                _listMeal.value = ApiRepository.getAllArea()
                val list = mutableListOf<String>()
                for (i in _listMeal.value.meals) {
                    i.strArea?.apply {
                        list.add(this)
                    }
                }
                _listString.value = list
            }
            getNavDirection = {
                StringListFragmentDirections.actionStringListDestToPreviewItemDest(
                    Constant.AREA_KEY,
                    it,
                    Constant.AREA_LABEL
                )
            }
        } catch (e: Exception) {
            // TODO
        }
    }
    private fun getAllCategory() {
        try {
            viewModelScope.launch {
                _listMeal.value = ApiRepository.getAllCategories()
                val list = mutableListOf<String>()
                for(i in _listMeal.value.meals) {
                    i.strCategory?.apply {
                        list.add(this)
                    }
                }
                _listString.value = list
            }
            getNavDirection = {
                StringListFragmentDirections.actionStringListDestToPreviewItemDest(Constant.CATEGORY_KEY,it,Constant.CATEGORY_LABEL)
            }
        } catch (e: Exception) {
            // TODO
        }
    }
}