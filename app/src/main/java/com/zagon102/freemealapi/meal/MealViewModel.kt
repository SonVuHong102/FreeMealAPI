package com.zagon102.freemealapi.meal

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagon102.freemealapi.network.Api
import kotlinx.coroutines.launch

class MealViewModel : ViewModel() {
    private val _strGet = MutableLiveData<String>()
    val strGet : LiveData<String> = _strGet

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _strGet.value = Api.retrofitService.get()
            Log.e("test","GOT DATA")
        }
    }
}