package com.zagon102.freemealapi.meal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zagon102.freemealapi.R
import com.zagon102.freemealapi.databinding.FragmentMainMealBinding
import com.zagon102.freemealapi.network.Api
import com.zagon102.freemealapi.network.Meal
import com.zagon102.freemealapi.network.Meals
import kotlinx.coroutines.*

class MainMealFragment : Fragment() {

    private var _binding: FragmentMainMealBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MealViewModel by viewModels()

    var testStr = "aaaaa"
    val getTestSt get() = testStr

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainMealBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.mainMealFragment = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        test()
    }

    fun test() {
        lifecycleScope.launch {
            testStr = Api.retrofitService.get()
            Log.e("test",testStr)
            binding.textView.text = testStr

        }

    }
}