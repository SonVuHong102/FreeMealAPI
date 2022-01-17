package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.zagon102.freemealapi.databinding.FragmentListViewBinding
import com.zagon102.freemealapi.viewmodel.ItemViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class PreviewItemFragment : Fragment() {
    private var _binding: FragmentListViewBinding? = null
    private val binding get() = _binding!!
    private val args: PreviewItemFragmentArgs by navArgs()
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListViewBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList(args.type,args.value)
        val adapter = PreviewItemAdapter(viewModel.getNavDirection,navigateByAction)
        binding.listView.adapter = adapter
        lifecycle.coroutineScope.launch {
            viewModel.listPreviewItem.collect() {
                adapter.submitList(it)
            }
        }
    }

    private val navigateByAction: (NavDirections) -> Unit = {
        findNavController().navigate(it)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}