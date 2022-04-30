package com.elchinasgarov.codinghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentLoginBinding


class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.forgotPasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_bottomNavigationFragment)
        }
    }
}
