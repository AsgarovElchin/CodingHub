package com.elchinasgarov.codinghub.ui.main.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.AnswersUIModel
import com.elchinasgarov.codinghub.databinding.AnswersListItemBinding
import com.elchinasgarov.codinghub.ui.main.viewholders.QuestionViewHolder

class QuestionAdapter : RecyclerView.Adapter<QuestionViewHolder>() {
    private var onItemClick: ((position: Int) -> Unit)? = null
    private val dataList = mutableListOf<AnswersUIModel>()

    fun setOnItemClick(onItemClick: ((position: Int) -> Unit)?) {
        this.onItemClick = onItemClick

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AnswersListItemBinding.inflate(inflater, parent, false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(dataList[position], onItemClick)
    }


    fun submitList(list: MutableList<AnswersUIModel>?) {
        dataList.clear()
        list?.let { dataList.addAll(it) }
        notifyDataSetChanged()


    }


    override fun getItemCount(): Int {
        return dataList.size
    }
}