package com.elchinasgarov.codinghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginFragment : Fragment(R.layout.fragment_login) {
    lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        binding.forgotPasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        binding.loginBtn.setOnClickListener {
            logInUser()
        }


    }

    private fun logInUser() {
        val email = binding.loginEmail.text.toString()
        val password = binding.loginPassword.text.toString()
        if (email.equals("") || password.equals("")) {
            Toast.makeText(requireContext(), "Enter email and password !", Toast.LENGTH_SHORT)
                .show()
        } else {
            CoroutineScope(Dispatchers.IO).launch {
                auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    findNavController().navigate(R.id.action_loginFragment_to_bottomNavigationFragment2)


                }.addOnFailureListener {
                    Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
