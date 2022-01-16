package com.zagon102.freemealapi.ui.meal

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zagon102.freemealapi.R
import com.zagon102.freemealapi.databinding.FragmentListViewBinding
import com.zagon102.freemealapi.databinding.TextItemViewBinding


class StringListAdapter(private val getNavDirections: (String) -> (NavDirections)) : ListAdapter<String,StringListAdapter.ViewHolder>(DiffCallBack) {
    companion object DiffCallBack : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(private var binding: TextItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.textItem.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(TextItemViewBinding.inflate(LayoutInflater.from(parent.context)))
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            parent.findNavController().navigate(getNavDirections(getItem(position)))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

    }
}