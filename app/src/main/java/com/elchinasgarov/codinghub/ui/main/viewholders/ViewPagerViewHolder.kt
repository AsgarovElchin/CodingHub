package com.elchinasgarov.codinghub.ui.main.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.ViewPagerItemBinding
import com.elchinasgarov.codinghub.ui.main.models.Data

class ViewPagerViewHolder(val binding:ViewPagerItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item : Data){
        binding.image.setImageResource(item.dataImage)
    }
}