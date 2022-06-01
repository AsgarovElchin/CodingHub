package com.elchinasgarov.codinghub.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.QuestionModel
import com.elchinasgarov.QuestionUIModel
import com.elchinasgarov.codinghub.ui.main.models.AnswerUIType
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuestionViewModel : ViewModel() {
    val currentPage = 0
    var questionList = listOf<QuestionUIModel>()
    private val firestore = Firebase.firestore
    private val _questionData = MutableLiveData<QuestionUIModel>()
    val questionData: LiveData<QuestionUIModel> = _questionData


    fun onAnswerSelect(answerPosition: Int) {
        val question = questionData.value
        question?.let { questionModel ->
            if (questionModel.correctAnswer == answerPosition) {
                question.answers?.get(answerPosition)?.type = AnswerUIType.CORRECT
            }
            else{
                question.answers?.get(question.correctAnswer)?.type = AnswerUIType.CORRECT
                question.answers?.get(answerPosition)?.type = AnswerUIType.FALSE

            }

            _questionData.value = questionModel

        }
    }

    fun getQuestionData(documentId: String, documentId2: String) {
        firestore.collection("PlCategory").document(documentId).collection("Sets")
            .document(documentId2).collection("Questions").get().addOnSuccessListener {
                val documents = it.documents
                val questions = documents.mapNotNull { doc ->
                    val questionModell = doc.toObject(QuestionModel::class.java)
                    questionModell?.id = doc.id
                    questionModell

                }
                questionList = questions.map { model->
                    model.toUIModel()
                }
                _questionData.value = questionList.first()

            }
    }


}