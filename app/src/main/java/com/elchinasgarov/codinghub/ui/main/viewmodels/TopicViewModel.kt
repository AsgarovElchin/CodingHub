package com.elchinasgarov.codinghub.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.codinghub.ui.main.models.TopicModel
import com.elchinasgarov.codinghub.utils.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class TopicViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private val _topicData = MutableLiveData<List<TopicModel>?>()
    val topicData: LiveData<List<TopicModel>?> = _topicData



    fun getTopicData(documentId:String){
        firestore.collection(Constants.CATEGORY_COLLECTION_NAME).document(documentId).collection(Constants.SETS).get().addOnSuccessListener {
            val documents = it.documents
            val topicList = documents.mapNotNull { doc ->
                val topicModell = doc.toObject(TopicModel::class.java)
                topicModell?.id = doc.id
                topicModell

            }
            _topicData.value = topicList

        }
    }




}