package com.elchinasgarov

import com.elchinasgarov.codinghub.ui.main.models.AnswerUIType


data class QuestionModel(
    var id: String = "",
    var question: String = "",
    var correctAnswer: Int = -1,
    var answers: List<String>? = null

){
    fun toUIModel() = QuestionUIModel(
        id = id,
        question = question,
        correctAnswer = correctAnswer,
        answers = answers?.mapIndexed { index,value->
            AnswersUIModel(
                id = index,
                answer = value
            )
        }
    )
}
data class QuestionUIModel(
    var id: String = "",
    var question: String = "",
    var correctAnswer: Int = -1,
    var answers: List<AnswersUIModel>? = null

)

data class AnswersUIModel(
    var id : Int,
    var answer : String,
    var type : AnswerUIType = AnswerUIType.NORMAL
)





