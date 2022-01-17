package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.zagon102.freemealapi.databinding.FragmentDetailItemBinding
import com.zagon102.freemealapi.network.ApiRepository
import com.zagon102.freemealapi.viewmodel.MealViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class DetailItemFragment : Fragment() {

    private var _binding: FragmentDetailItemBinding? = null
    private val binding get() = _binding!!
    private val args: DetailItemFragmentArgs by navArgs()
    private val viewModel: MealViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailItemBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        lifecycle.coroutineScope.launch{
//            val list = ApiRepository.getMealDetail(52967)
//            Log.e("TESTTT", list.meals?.size.toString() + list.meals!!.get(0).strMeal)
//        }
        viewModel.getMeal(args.id)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.currentMeal.collect() {
                it?.meals?.let { listMeal ->
                    if(listMeal.isEmpty())
                        return@collect
                    val meal = listMeal[0]
                    binding.detailItemTitle.text = meal.strMeal
                    binding.detailItemDescription.text = meal.strInstructions
                    binding.detailItemImg.load(meal.strMealThumb)
                    binding.detailItemLabel.text = meal.strMeal
                }
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    
}