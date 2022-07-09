package com.elchinasgarov.codinghub.ui.main.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elchinasgarov.codinghub.ui.main.models.ProgrammingLanguagesModel
import com.elchinasgarov.codinghub.utils.Constants
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class PlCategoryViewModel : ViewModel() {
    private val firestore = Firebase.firestore
    private val _dataFirebase = MutableLiveData<List<ProgrammingLanguagesModel>?>()
    val dataFirebase: LiveData<List<ProgrammingLanguagesModel>?>
        get() = _dataFirebase


    fun getPlDataFromFirebase() {
        firestore.collection(Constants.CATEGORY_COLLECTION_NAME).get().addOnSuccessListener {
            val documents = it.documents
            val plList = documents.mapNotNull { doc ->
                val plModell = doc.toObject(ProgrammingLanguagesModel::class.java)
                plModell?.id = doc.id
                plModell

            }
            _dataFirebase.value = plList


        }

    }


}