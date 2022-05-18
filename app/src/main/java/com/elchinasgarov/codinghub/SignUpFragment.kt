package com.elchinasgarov.codinghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private lateinit var binding : FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginTv.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }



    }
}