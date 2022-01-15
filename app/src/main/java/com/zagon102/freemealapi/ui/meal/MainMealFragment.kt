package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.zagon102.freemealapi.R
import com.zagon102.freemealapi.databinding.FragmentMainMealBinding
import com.zagon102.freemealapi.viewmodel.MealViewModel

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
            val action = MainMealFragmentDirections.actionMealDestToListViewFragment(getString(R.string.area_key),getString(R.string.area_label))
            findNavController().navigate(action)
        }

        binding.search.setOnClickListener{

        }
        return binding.root
    }
}