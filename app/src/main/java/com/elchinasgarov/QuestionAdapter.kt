package com.elchinasgarov


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.codinghub.databinding.QuestionItemListBinding
import com.elchinasgarov.codinghub.ui.main.models.ProgrammingLanguagesModel

class QuestionAdapter : ListAdapter<QuestionModel, QuestionViewHolder>(MainDiffUtils) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = QuestionItemListBinding.inflate(inflater, parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(currentList[position])
    }


    object MainDiffUtils : DiffUtil.ItemCallback<QuestionModel>() {

        override fun areItemsTheSame(
            oldItem: QuestionModel,
            newItem: QuestionModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: QuestionModel,
            newItem: QuestionModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }
}