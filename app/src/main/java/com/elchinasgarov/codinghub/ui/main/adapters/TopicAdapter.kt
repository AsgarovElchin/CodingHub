package com.elchinasgarov.codinghub.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.QuestionModel
import com.elchinasgarov.codinghub.databinding.TopicItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.TopicModel
import com.elchinasgarov.codinghub.ui.main.viewholders.TopicViewHolder

class TopicAdapter : ListAdapter<TopicModel, TopicViewHolder>(MainDiffUtils) {
    private var onItemClick: ((topic : TopicModel) -> Unit)? = null

    fun setOnItemClick(onItemClick: ((topic: TopicModel) -> Unit)?){
        this.onItemClick = onItemClick

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TopicItemListBinding.inflate(inflater, parent, false)
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(currentList[position],onItemClick)
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