package com.elchinasgarov

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.codinghub.ui.main.models.TopicModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class QuestionViewModel:ViewModel() {
    private val firestore = Firebase.firestore
    private val _questionData = MutableLiveData<List<QuestionModel>?>()
    val questionData : LiveData<List<QuestionModel>?> = _questionData

    fun getQuestionData(documentId:String,documentId2:String){
        firestore.collection("PlCategory").document(documentId).collection("Sets")
            .document(documentId2).collection("Questions").get().addOnSuccessListener {
            val documents = it.documents
            val questionList = documents.mapNotNull { doc ->
                val questionModell = doc.toObject(QuestionModel::class.java)
                questionModell?.id = doc.id
                questionModell

            }
           _questionData.value = questionList

        }
    }



}