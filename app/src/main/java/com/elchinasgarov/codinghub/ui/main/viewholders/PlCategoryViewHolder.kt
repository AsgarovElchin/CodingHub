package com.elchinasgarov.codinghub.ui.main.viewholders

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elchinasgarov.codinghub.databinding.PlItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.ProgrammingLanguagesModel

class PlCategoryViewHolder(val binding: PlItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(plModel : ProgrammingLanguagesModel){
        binding.plImage.load(plModel.imageUrl)
        binding.plTitle.text = plModel.title
    }
}

