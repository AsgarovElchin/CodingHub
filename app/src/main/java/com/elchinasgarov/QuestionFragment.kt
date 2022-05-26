package com.elchinasgarov

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment(R.layout.fragment_question) {
    private lateinit var binding: FragmentQuestionBinding
    private val questionAdapter = QuestionAdapter()
    private val questionViewModel: QuestionViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val documentId2 = arguments?.getString("documentId2")
        val documentId = arguments?.getString("documentId")
        if (documentId != null && documentId2 != null) {
            questionViewModel.getQuestionData(documentId, documentId2)
        }
        Log.d("Tag","$documentId and $documentId2")

        questionViewModel.questionData.observe(viewLifecycleOwner) { qList ->
            qList?.let { questionList ->
                questionAdapter.submitList(questionList.toMutableList())
            }

        }

        binding.questionRV.adapter = questionAdapter
        binding.questionRV.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


    }

}