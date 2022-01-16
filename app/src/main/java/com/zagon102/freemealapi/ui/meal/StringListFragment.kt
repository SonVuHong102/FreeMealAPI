package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.navArgs
import com.zagon102.freemealapi.databinding.FragmentListViewBinding
import com.zagon102.freemealapi.viewmodel.MealViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class StringListFragment : Fragment() {
    private var _binding: FragmentListViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MealViewModel by activityViewModels()

    private val args: StringListFragmentArgs by navArgs()
    private lateinit var type: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListViewBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initiateRecyclerView()
    }

    private fun initiateRecyclerView() {
        type = args.type
        viewModel.getList(type)
        val adapter = StringListAdapter()
        binding.listView.adapter = adapter
        lifecycle.coroutineScope.launch {
            viewModel.listString.collect() {
                adapter.submitList(it)
            }
        }
    }
}
