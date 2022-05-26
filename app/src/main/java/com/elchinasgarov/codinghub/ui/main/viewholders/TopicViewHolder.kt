package com.elchinasgarov.codinghub.ui.main.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.TopicItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.TopicModel

class TopicViewHolder(val binding: TopicItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(topic: TopicModel) {
        binding.topicTitle.text = topic.name
    }

    }


