package com.elchinasgarov.codinghub.ui.main.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.elchinasgarov.AnswersUIModel
import com.elchinasgarov.codinghub.ui.main.viewholders.QuestionViewHolder
import com.elchinasgarov.codinghub.databinding.AnswersListItemBinding

class QuestionAdapter : ListAdapter<AnswersUIModel, QuestionViewHolder>(MainDiffUtils) {
    private var onItemClick: ((position : Int) -> Unit)? = null

    fun setOnItemClick(onItemClick: ((position : Int) -> Unit)?){
        this.onItemClick = onItemClick

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnswersListItemBinding.inflate(inflater, parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(currentList[position],onItemClick)
    }


    override fun submitList(list: MutableList<AnswersUIModel>?) {
        val newList = mutableListOf<AnswersUIModel>()
        newList.addAll(list ?: mutableListOf())
        Log.d("Yuuuuuuu","type : ${list.toString()}")
        super.submitList(newList)

    }
    object MainDiffUtils : DiffUtil.ItemCallback<AnswersUIModel>() {

        override fun areItemsTheSame(
            oldItem: AnswersUIModel,
            newItem: AnswersUIModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: AnswersUIModel,
            newItem: AnswersUIModel
        ): Boolean {
            return oldItem.id == newItem.id ||
                    oldItem.answer == newItem.answer ||
                    oldItem.type == newItem.type
        }

    }
}