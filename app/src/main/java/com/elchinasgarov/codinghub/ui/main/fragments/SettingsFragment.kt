package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        binding.singOut.setOnClickListener {
            auth.signOut()
            parentFragment?.parentFragment?.findNavController()
                ?.navigate(R.id.action_bottomNavigationFragment2_to_loginOrSignUpFragment)
        }
        binding.linear1.setOnClickListener {
            parentFragment?.parentFragment?.findNavController()?.navigate(R.id.editProfileFragment)
        }




    }

}