package com.elchinasgarov.codinghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentResetPasswordBinding


class ResetPasswordFragment : Fragment(R.layout.fragment_reset_password) {
    private lateinit var binding: FragmentResetPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResetPasswordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPassword2Tv.setOnClickListener{
            findNavController().navigate(R.id.action_resetPasswordFragment_to_newPasswordFragment)
        }
    }
}