package com.elchinasgarov.codinghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.elchinasgarov.codinghub.databinding.FragmentBottomNavigationBinding


class BottomNavigationFragment : Fragment(R.layout.fragment_bottom_navigation) {
    lateinit var binding: FragmentBottomNavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBottomNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        binding.bnv.setupWithNavController(navHost.navController)
        binding.bnv.setOnItemReselectedListener(null)
    }


    fun logOut(){
        findNavController().navigate(R.id.action_bottomNavigationFragment2_to_loginOrSignUpFragment)
    }



}