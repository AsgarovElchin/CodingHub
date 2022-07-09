package com.elchinasgarov.codinghub.utils

import android.util.Log
import com.elchinasgarov.codinghub.ui.main.models.UserModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object UserInformation {
    var userInfo: UserModel? = null
        private set

    fun getUserInfo(userEmail: String?) {
        Log.d("kkk","$userEmail")
        if(userEmail == null){
            return
        }
        Firebase.firestore.collection("Users").document(userEmail).get().addOnSuccessListener {
            userInfo = it.toObject(UserModel::class.java)
            Log.d("kkkkk","${userInfo}")

        }.addOnFailureListener {
            it.printStackTrace()
            Log.d("test","${it.localizedMessage}")
        }


    }
}