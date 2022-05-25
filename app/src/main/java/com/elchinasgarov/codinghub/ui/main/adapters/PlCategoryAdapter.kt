package com.elchinasgarov.codinghub.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.codinghub.databinding.PlItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.ProgrammingLanguagesModel
import com.elchinasgarov.codinghub.ui.main.viewholders.PlCategoryViewHolder

class PlCategoryAdapter() :
    ListAdapter<ProgrammingLanguagesModel, PlCategoryViewHolder>(MainDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PlItemListBinding.inflate(inflater, parent, false)
        return PlCategoryViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PlCategoryViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    object MainDiffUtils : DiffUtil.ItemCallback<ProgrammingLanguagesModel>() {
        override fun areItemsTheSame(
            oldItem: ProgrammingLanguagesModel,
            newItem: ProgrammingLanguagesModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingLanguagesModel,
            newItem: ProgrammingLanguagesModel
        ): Boolean {
            return oldItem.id == newItem.id
        }


    }
}