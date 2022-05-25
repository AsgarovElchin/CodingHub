package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.ui.main.adapters.ViewPagerAdapter
import com.elchinasgarov.codinghub.databinding.FragmentLoginOrSignUpBinding
import com.elchinasgarov.codinghub.ui.main.models.Data


class LoginOrSignUpFragment : Fragment(R.layout.fragment_login_or_sign_up) {
    private lateinit var binding : FragmentLoginOrSignUpBinding
    private var adapter = ViewPagerAdapter(getData())
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginOrSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun getData()= arrayListOf(
        Data(R.drawable.illustration3),
        Data(R.drawable.illustration2),
        Data(R.drawable.illustration1)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnWelcomeLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginOrSignUpFragment_to_loginFragment)
        }
        binding.btnWelcomeCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginOrSignUpFragment_to_signUpFragment)
        }
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }

}