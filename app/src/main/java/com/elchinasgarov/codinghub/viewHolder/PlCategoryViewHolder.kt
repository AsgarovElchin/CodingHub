package com.elchinasgarov.codinghub.viewHolder

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elchinasgarov.codinghub.databinding.PlItemListBinding
import com.elchinasgarov.codinghub.models.ProgrammingLanguagesModel

class PlCategoryViewHolder(val binding: PlItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(plModel : ProgrammingLanguagesModel){
        binding.plImage.load(plModel.imageUrl)
        binding.plTitle.text = plModel.title
    }
}

