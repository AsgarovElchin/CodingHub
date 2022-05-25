package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.elchinasgarov.codinghub.R

import com.elchinasgarov.codinghub.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        binding.bnv.setupWithNavController(navHost.navController)
        binding.bnv.setOnItemReselectedListener(null)
        val conf = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.leaderboardFragment,
            R.id.settingsFragment
        ).build()

        binding.mainToolbar.setupWithNavController(navHost.navController,conf)
    }


    fun logOut(){
        findNavController().navigate(R.id.action_bottomNavigationFragment2_to_loginOrSignUpFragment)
    }



}