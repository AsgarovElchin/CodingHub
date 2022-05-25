package com.elchinasgarov

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.elchinasgarov.codinghub.R
import com.elchinasgarov.codinghub.databinding.FragmentTopicBinding


class TopicFragment : Fragment(R.layout.fragment_topic) {
   private lateinit var binding : FragmentTopicBinding
   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      binding = FragmentTopicBinding.inflate(inflater,container,false)
      return binding.root
   }
}