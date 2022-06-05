package com.elchinasgarov.codinghub.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.QuestionModel
import com.elchinasgarov.QuestionUIModel
import com.elchinasgarov.codinghub.ui.main.models.AnswerResult
import com.elchinasgarov.codinghub.ui.main.models.AnswerUIType
import com.elchinasgarov.codinghub.ui.main.models.NextButtonState
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuestionViewModel : ViewModel() {
    var currentPage = 0
    var questionList = listOf<QuestionUIModel>()
    private val firestore = Firebase.firestore
    private val _questionData = MutableLiveData<QuestionUIModel>()
    val questionData: LiveData<QuestionUIModel> = _questionData
    private val userAnswersList = mutableListOf<AnswerResult>()
    private var languageId : String? = null
    private var topicId : String? = null
    private val _nextButtonState = MutableLiveData<NextButtonState>(NextButtonState.DEACTIVE)
    val nextButtonState : LiveData<NextButtonState> = _nextButtonState


    fun onAnswerSelect(answerPosition: Int) {
        val question = questionData.value
        question?.let { questionModel ->
            if (questionModel.correctAnswer == answerPosition) {
                question.answers?.get(answerPosition)?.type = AnswerUIType.CORRECT
                setUserAnswerResult(question.id,true)

            }
            else{
                question.answers?.get(question.correctAnswer)?.type = AnswerUIType.CORRECT
                question.answers?.get(answerPosition)?.type = AnswerUIType.FALSE
                setUserAnswerResult(question.id,false)


            }

            _questionData.value = questionModel
            _nextButtonState.value = NextButtonState.ACTIVE

        }
    }

    fun getQuestionData(documentId: String, documentId2: String) {
        languageId = documentId
        topicId = documentId2
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
                _nextButtonState.value = NextButtonState.DEACTIVE

            }
    }
    private fun setUserAnswerResult(questionId : String,isAnswerCorrect:Boolean){
        userAnswersList.add(AnswerResult(
            languageId,topicId,questionId,isAnswerCorrect
        ))
    }

    fun getNextQuestion(){
        currentPage++
        Log.d("tag",userAnswersList.toString())
        if(questionList.size-1==currentPage){
            _nextButtonState.value = NextButtonState.END
        }
        if(questionList.size>currentPage){
            _questionData.value = questionList.get(currentPage)
            _nextButtonState.value = NextButtonState.DEACTIVE
        }
        else{
            if(nextButtonState.value == NextButtonState.END){
                sendResults()
            }
            _nextButtonState.value = NextButtonState.END
        }

    }
    private fun sendResults(){
        Log.d("uuuuuuuuuuuuuuu","sending results->${userAnswersList.toString()}")
    }


}