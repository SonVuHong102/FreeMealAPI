package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.zagon102.freemealapi.databinding.FragmentMainMealBinding
import com.zagon102.freemealapi.viewmodel.MealViewModel

class MainMealFragment : Fragment() {

    private var _binding: FragmentMainMealBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MealViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMealBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.mainMealFragment = this

        return binding.root
    }

}