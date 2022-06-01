package com.elchinasgarov.codinghub.ui.main.viewholders

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.AnswersUIModel
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.AnswersListItemBinding
import com.elchinasgarov.codinghub.ui.main.models.AnswerUIType
import com.elchinasgarov.codinghub.utils.setBackgroundColorByRes


class QuestionViewHolder(val binding: AnswersListItemBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(answersUIModel : AnswersUIModel, onItemClick: ((position : Int) -> Unit)?){
        binding.answerText.text = answersUIModel.answer
        binding.answerCard.setOnClickListener {
            onItemClick?.invoke(answersUIModel.id)

        }
        Log.d("Tag","type : ${answersUIModel.type}")
        binding.answerCard.setBackgroundColorByRes(getColorByType(answersUIModel.type))



    }
    private fun getColorByType(type:AnswerUIType) =
        when(type){
            AnswerUIType.CORRECT->R.color.green
            AnswerUIType.FALSE->R.color.red
            else->R.color.white
        }


}