package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.FragmentEditProfileBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class EditProfileFragment : Fragment(R.layout.fragment_edit_profile) {
    private lateinit var binding: FragmentEditProfileBinding
    val firestore = Firebase.firestore
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveBtn.setOnClickListener {
            addProfileDataToFireStore()
        }

    }


    fun addProfileDataToFireStore() {
        val userInfo = hashMapOf(
            "email" to binding.email.text.toString(),
            "username" to binding.username.text.toString(),
            "phone" to binding.phone.text.toString(),
            "gender" to binding.gender.text.toString().toInt(),
            "dateOfBirth" to binding.dateOfBirth.text.toString()
        )
        firestore.collection("Users").document(binding.email.text.toString()).set(userInfo)




    }

}