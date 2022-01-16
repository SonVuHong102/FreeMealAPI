package com.zagon102.freemealapi.ui.meal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.zagon102.freemealapi.R
import com.zagon102.freemealapi.databinding.FragmentPreviewItemBinding


class PreviewItemFragment : Fragment() {
    private var _binding: FragmentPreviewItemBinding? = null
    private val binding get() = _binding!!
    private val args: PreviewItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPreviewItemBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val type = args.type
        val value = args.value
        Log.e("TESTTTTT","$type $value")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}