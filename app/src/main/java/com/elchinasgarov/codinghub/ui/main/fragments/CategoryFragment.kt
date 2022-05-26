package com.elchinasgarov.codinghub.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.ui.main.adapters.PlCategoryAdapter
import com.elchinasgarov.codinghub.databinding.FragmentCategoryBinding
import com.elchinasgarov.codinghub.ui.main.viewmodels.PlCategoryViewModel


class CategoryFragment : Fragment(R.layout.fragment_category) {
    private val plCategoryAdapter = PlCategoryAdapter()
    private val viewModel: PlCategoryViewModel by viewModels()
    lateinit var binding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getPlDataFromFirebase()
        viewModel.dataFirebase.observe(viewLifecycleOwner) { newDataList ->
            newDataList?.let { list ->
                plCategoryAdapter.submitList(list.toMutableList())
            }
        }
        binding.RvPlCategory.adapter = plCategoryAdapter
        binding.RvPlCategory.layoutManager = GridLayoutManager(context, 2)
        plCategoryAdapter.setOnItemClick {
            findNavController().navigate(R.id.action_categoryFragment_to_topicFragment,
            bundleOf(
                "id" to it.id
            ))


        }

    }




}