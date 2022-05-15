package com.elchinasgarov.codinghub

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.elchinasgarov.codinghub.adapter.PlCategoryAdapter
import com.elchinasgarov.codinghub.databinding.FragmentHomeBinding
import com.elchinasgarov.codinghub.viewModels.PlCategoryViewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val plCategoryAdapter = PlCategoryAdapter()
    private val viewModel: PlCategoryViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
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

    }


}