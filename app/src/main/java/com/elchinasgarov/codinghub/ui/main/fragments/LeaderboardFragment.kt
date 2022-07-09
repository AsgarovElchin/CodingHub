package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.FragmentLeaderboardBinding
import com.elchinasgarov.codinghub.ui.main.adapters.LeaderBoardAdapter
import com.elchinasgarov.codinghub.ui.main.viewmodels.LeaderBoardViewModel

class LeaderboardFragment : Fragment(R.layout.fragment_leaderboard) {
    private lateinit var binding: FragmentLeaderboardBinding
    private val leaderBoardAdapter by lazy { LeaderBoardAdapter() }
    private val leaderBoardViewModel: LeaderBoardViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeaderboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        leaderBoardViewModel.getLeaderBoardData()
        leaderBoardViewModel.leaderBoardData.observe(viewLifecycleOwner){leaderBoardList->
            leaderBoardAdapter.submitList(leaderBoardList)
        }

    }

    private fun setupRecyclerView(){
        binding.leaderBoardRv.adapter = leaderBoardAdapter

    }

}