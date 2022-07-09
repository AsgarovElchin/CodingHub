package com.elchinasgarov.codinghub.ui.main.viewholders

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.elchinasgarov.codinghub.databinding.LeaderBoardItemBinding
import com.elchinasgarov.codinghub.ui.main.models.LeaderBoardModel

class LeaderBoardViewHolder(val binding: LeaderBoardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(leaderBoardModel: LeaderBoardModel) {
        binding.avatarImage.load(leaderBoardModel.avatar)
        binding.fullName.text = leaderBoardModel.fullName
        binding.point.text = leaderBoardModel.points.toString()
    }
}