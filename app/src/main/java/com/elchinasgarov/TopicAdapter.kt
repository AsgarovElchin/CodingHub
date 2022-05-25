package com.elchinasgarov

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.codinghub.databinding.TopicItemListBinding

class TopicAdapter : ListAdapter<TopicModel, TopicViewHolder>(MainDiffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemListBinding.inflate(inflater, parent, false)
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    object MainDiffUtils : DiffUtil.ItemCallback<TopicModel>() {
        override fun areItemsTheSame(
            oldItem: TopicModel,
            newItem: TopicModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: TopicModel,
            newItem: TopicModel
        ): Boolean {
            return oldItem.id == newItem.id
        }


    }

}