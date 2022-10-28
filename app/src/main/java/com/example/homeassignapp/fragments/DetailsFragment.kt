package com.example.homeassignapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homeassignapp.databinding.FragmentDetailsBinding
import com.example.homeassignapp.viewmodels.SharedViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val svm: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.svm = svm

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}