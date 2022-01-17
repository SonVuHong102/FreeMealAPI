package com.zagon102.freemealapi.ui.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zagon102.freemealapi.databinding.PreviewItemViewBinding
import com.zagon102.freemealapi.model.PreviewItem


class PreviewItemAdapter(
    private val getNavDirections: (String,String) -> (NavDirections),
    private val navigateByAction: (NavDirections) -> Unit)
    : ListAdapter<PreviewItem,PreviewItemAdapter.ViewHolder>(DiffCallBack) {
    companion object DiffCallBack : DiffUtil.ItemCallback<PreviewItem>() {
        override fun areItemsTheSame(oldItem: PreviewItem, newItem: PreviewItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PreviewItem, newItem: PreviewItem): Boolean {
            return oldItem.title == newItem.title || oldItem.imgSrc == oldItem.imgSrc
        }
    }

    class ViewHolder(private val binding: PreviewItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PreviewItem) {
            binding.previewDescription.text = item.description
            binding.previewImage.load(item.imgSrc)
            binding.previewTitle.text = item.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ViewHolder(PreviewItemViewBinding.inflate(LayoutInflater.from(parent.context)))
        viewHolder.itemView.setOnClickListener{
            val item = getItem(viewHolder.adapterPosition)
            navigateByAction(getNavDirections(item.id,item.title))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}