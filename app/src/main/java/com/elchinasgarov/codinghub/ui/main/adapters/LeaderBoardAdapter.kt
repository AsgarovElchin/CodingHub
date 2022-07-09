package com.elchinasgarov.codinghub.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.codinghub.databinding.LeaderBoardItemBinding
import com.elchinasgarov.codinghub.databinding.PlItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.LeaderBoardModel
import com.elchinasgarov.codinghub.ui.main.models.ProgrammingLanguagesModel
import com.elchinasgarov.codinghub.ui.main.viewholders.LeaderBoardViewHolder
import com.elchinasgarov.codinghub.ui.main.viewholders.PlCategoryViewHolder

class LeaderBoardAdapter:ListAdapter<LeaderBoardModel,LeaderBoardViewHolder>(MainDiffUtils) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderBoardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LeaderBoardItemBinding.inflate(inflater, parent, false)
        return LeaderBoardViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LeaderBoardViewHolder, position: Int) {
        holder.bind(currentList[position])

    }

    object MainDiffUtils : DiffUtil.ItemCallback<LeaderBoardModel>() {
        override fun areItemsTheSame(
            oldItem: LeaderBoardModel,
            newItem: LeaderBoardModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: LeaderBoardModel,
            newItem: LeaderBoardModel
        ): Boolean {
            return oldItem.id == newItem.id
        }


    }

}