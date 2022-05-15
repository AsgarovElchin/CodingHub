package com.elchinasgarov.codinghub.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.codinghub.models.ProgrammingLanguagesModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PlCategoryViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private val _dataFirebase = MutableLiveData<List<ProgrammingLanguagesModel>?>()
    val dataFirebase: LiveData<List<ProgrammingLanguagesModel>?>
        get() = _dataFirebase


    fun getPlDataFromFirebase() {
        firestore.collection(NAME).get().addOnSuccessListener {
            val documents = it.documents
            val plList = documents.mapNotNull { doc ->
                val plModell = doc.toObject(ProgrammingLanguagesModel::class.java)
                plModell?.id = doc.id
                plModell

            }
            _dataFirebase.value = plList


        }

    }

    companion object {
        const val NAME = "PlCategory"
    }

}