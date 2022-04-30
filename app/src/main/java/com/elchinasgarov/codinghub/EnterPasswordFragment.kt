package com.elchinasgarov.codinghub

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentEnterPasswordBinding


class EnterPasswordFragment : Fragment(R.layout.fragment_enter_password) {
    private lateinit var binding : FragmentEnterPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterPasswordBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPassword2Tv.setOnClickListener {
            findNavController().navigate(R.id.action_enterPasswordFragment_to_enterUsernameFragment)
        }
    }
}