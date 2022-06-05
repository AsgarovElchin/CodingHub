package com.elchinasgarov.codinghub.ui.main.models

data class AnswerResult(
    var languageId: String?,
    var topicId: String?,
    var questionId: String,
    var isAnswerCorrect: Boolean
)
