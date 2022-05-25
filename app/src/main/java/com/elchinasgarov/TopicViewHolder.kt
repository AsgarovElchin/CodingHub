package com.elchinasgarov

import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.TopicItemListBinding

class TopicViewHolder(val binding: TopicItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(topic:TopicModel){
        binding.topicTitle.text = topic.name
    }
}