package com.elchinasgarov.codinghub.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.ViewPagerItemBinding
import com.elchinasgarov.codinghub.models.Data
import java.util.*

class ViewPagerViewHolder(val binding:ViewPagerItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(item : Data){
        binding.image.setImageResource(item.dataImage)
    }
}