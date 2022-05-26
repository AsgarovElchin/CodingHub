package com.elchinasgarov


data class QuestionModel(
    var id: String = "",
    var question: String = "",
    var correctAnswer: String = "",
    var answers: Map<String,String>? = null

)

data class AnswersData(
    var a: String = "",
    var b: String = "",
    var c: String = "",
    var d: String = ""
)



