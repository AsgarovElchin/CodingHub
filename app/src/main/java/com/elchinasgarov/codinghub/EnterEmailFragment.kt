package com.elchinasgarov.codinghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.databinding.FragmentEnterEmailBinding


class EnterEmailFragment : Fragment(R.layout.fragment_enter_email) {
    private lateinit var binding : FragmentEnterEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterEmailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resetPassword1Tv.setOnClickListener {
            findNavController().navigate(R.id.action_enterEmailFragment_to_enterPasswordFragment)
        }
    }
}