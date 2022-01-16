package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zagon102.freemealapi.constant.Constant
import com.zagon102.freemealapi.databinding.FragmentMainMealBinding

class MainMealFragment : Fragment() {

    private var _binding: FragmentMainMealBinding? = null
    private val binding get() = _binding!!

//    private val viewModel: MealViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMealBinding.inflate(inflater)
        binding.searchAreaBtn.setOnClickListener{
            val action = MainMealFragmentDirections.actionMealDestToListViewFragment(Constant.AREA_KEY,Constant.AREA_LABEL)
            findNavController().navigate(action)
        }
        binding.searchCategoryBtn.setOnClickListener{
            val action = MainMealFragmentDirections.actionMealDestToListViewFragment(Constant.CATEGORY_KEY,Constant.CATEGORY_LABEL)
            findNavController().navigate(action)
        }
        return binding.root
    }
}