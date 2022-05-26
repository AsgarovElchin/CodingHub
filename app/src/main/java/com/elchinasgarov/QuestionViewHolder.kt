package com.elchinasgarov

import androidx.recyclerview.widget.RecyclerView
import com.elchinasgarov.codinghub.databinding.QuestionItemListBinding

class QuestionViewHolder(val binding: QuestionItemListBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(questionModel: QuestionModel){
        binding.questionTextView.text = questionModel.question
        //binding.answerTextView1.text = questionModel.answers.a
       // binding.answerTextView2.text = questionModel.answers.b
       // binding.answerTextView3.text = questionModel.answers.c
       // binding.answerTextView4.text = questionModel.answers.d
    }
}