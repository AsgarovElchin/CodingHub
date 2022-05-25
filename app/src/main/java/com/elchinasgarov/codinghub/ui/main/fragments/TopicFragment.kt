package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.elchinasgarov.TopicAdapter
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.TopicViewModel
import com.elchinasgarov.codinghub.databinding.FragmentTopicBinding


class TopicFragment : Fragment(R.layout.fragment_topic) {
    private val topicViewModel: TopicViewModel by viewModels()
    private val topicAdapter = TopicAdapter()
    private lateinit var binding: FragmentTopicBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val documentId = arguments?.getString("id")
        Log.d("Tag","$documentId")
        if (documentId != null) {
            topicViewModel.getTopicData(documentId)
        }
        Log.d("Tag","$documentId")
        topicViewModel.topicData.observe(viewLifecycleOwner) { newTopicList ->
            newTopicList?.let { topicList ->
                topicAdapter.submitList(topicList.toMutableList())
            }
            Log.d("Tag","$newTopicList")
        }



        binding.topicRV.adapter = topicAdapter
        binding.topicRV.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


    }

}