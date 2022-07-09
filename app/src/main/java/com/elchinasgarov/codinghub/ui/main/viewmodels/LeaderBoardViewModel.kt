package com.elchinasgarov.codinghub.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elchinasgarov.codinghub.ui.main.models.LeaderBoardModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LeaderBoardViewModel() : ViewModel() {
    val firestore = Firebase.firestore
    private val _leaderBoardData = MutableLiveData<List<LeaderBoardModel>>()
    val leaderBoardData: LiveData<List<LeaderBoardModel>> = _leaderBoardData

    fun getLeaderBoardData() {
        viewModelScope.launch {
            firestore.collection("Results").get().addOnSuccessListener {
                val documents = it.documents
                val leaderBoardList = documents.mapNotNull { doc ->
                    val leaderBoardM = doc.toObject(LeaderBoardModel::class.java)
                    leaderBoardM?.id = doc.id
                    leaderBoardM

                }
                _leaderBoardData.value = leaderBoardList
            }
        }
    }

}