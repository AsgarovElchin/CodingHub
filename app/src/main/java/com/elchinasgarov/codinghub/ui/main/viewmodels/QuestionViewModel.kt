package com.elchinasgarov.codinghub.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elchinasgarov.QuestionModel
import com.elchinasgarov.QuestionUIModel
import com.elchinasgarov.codinghub.ui.main.models.AnswerResult
import com.elchinasgarov.codinghub.ui.main.models.AnswerUIType
import com.elchinasgarov.codinghub.ui.main.models.LeaderBoardModel
import com.elchinasgarov.codinghub.ui.main.models.NextButtonState
import com.elchinasgarov.codinghub.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class QuestionViewModel : ViewModel() {
    var currentPage = 0
    var questionList = listOf<QuestionUIModel>()
    private val firestore = Firebase.firestore
    private val _questionData = MutableLiveData<QuestionUIModel>()
    val questionData: LiveData<QuestionUIModel> = _questionData
    private val userAnswersList = mutableListOf<AnswerResult>()
    private var languageId: String? = null
    private var topicId: String? = null
    private var userPoint: Int = 0
    private val _nextButtonState = MutableLiveData<NextButtonState>(NextButtonState.DEACTIVE)
    val nextButtonState: LiveData<NextButtonState> = _nextButtonState


    fun onAnswerSelect(answerPosition: Int) {
        val question = questionData.value
        question?.let { questionModel ->
            if (questionModel.correctAnswer == answerPosition) {
                question.answers?.get(answerPosition)?.type = AnswerUIType.CORRECT
                setUserAnswerResult(question.id, true)
                userPoint += 10

            } else {
                question.answers?.get(question.correctAnswer)?.type = AnswerUIType.CORRECT
                question.answers?.get(answerPosition)?.type = AnswerUIType.FALSE
                setUserAnswerResult(question.id, false)


            }

            _questionData.value = questionModel
            _nextButtonState.value = NextButtonState.ACTIVE

        }
    }

    fun getQuestionData(documentId: String, documentId2: String) {
        languageId = documentId
        topicId = documentId2
        firestore.collection(Constants.CATEGORY_COLLECTION_NAME).document(documentId).collection("Sets")
            .document(documentId2).collection(Constants.QUESTIONS).get().addOnSuccessListener {
                val documents = it.documents
                val questions = documents.mapNotNull { doc ->
                    val questionModell = doc.toObject(QuestionModel::class.java)
                    questionModell?.id = doc.id
                    questionModell

                }
                questionList = questions.map { model ->
                    model.toUIModel()
                }
                _questionData.value = questionList.first()
                _nextButtonState.value = NextButtonState.DEACTIVE

            }
    }

    private fun setUserAnswerResult(questionId: String, isAnswerCorrect: Boolean) {
        userAnswersList.add(
            AnswerResult(
                languageId, topicId, questionId, isAnswerCorrect
            )
        )
    }

    fun getNextQuestion() {
        currentPage++
        Log.d("tag", userAnswersList.toString())
        if (questionList.size - 1 == currentPage) {
            _nextButtonState.value = NextButtonState.END
        }
        if (questionList.size > currentPage) {
            _questionData.value = questionList.get(currentPage)
            _nextButtonState.value = NextButtonState.DEACTIVE
        } else {
            if (nextButtonState.value == NextButtonState.END) {
                sendResults()
            }
            _nextButtonState.value = NextButtonState.END
        }

    }

    private fun sendResults() {
        var finalPoint = userPoint
        val email = FirebaseAuth.getInstance().currentUser?.email
        var userOldResults: LeaderBoardModel? = null
        Log.d("email", "$email")
        email?.let {
            viewModelScope.launch {
                Log.d("uuu", "$it")
                try {
                    userOldResults = getUserOldResult(it)
                } catch (e: Exception) {
                    Log.d("userResultFail", "${e.localizedMessage}")
                }

                userOldResults?.points?.let {
                    finalPoint += it
                }
                val leaderBoardModel = LeaderBoardModel(
                    avatar = "",
                    fullName = email,
                    points = finalPoint
                )
                Log.d("leader", "$leaderBoardModel")
                Firebase.firestore.collection("Results").document(email).set(leaderBoardModel)

            }

        }


    }

    private suspend fun getUserOldResult(email: String): LeaderBoardModel? {
        var userOldResults: LeaderBoardModel? = null
        coroutineScope {
            val result = async {
                Firebase.firestore.collection(Constants.RESULTS).document(email).get()
            }
            Log.d("result", "result:$result")
            userOldResults = result.await().result.toObject(LeaderBoardModel::class.java)
            Log.d("result", "userOldResult:$userOldResults")

        }

        return userOldResults
    }


}