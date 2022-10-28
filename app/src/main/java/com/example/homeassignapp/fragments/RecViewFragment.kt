package com.example.homeassignapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homeassignapp.adapters.RecViewAdapter
import com.example.homeassignapp.databinding.FragmentRecViewBinding
import com.example.homeassignapp.viewmodels.SharedViewModel

class RecViewFragment : Fragment() {

    private var _binding: FragmentRecViewBinding? = null
    private val binding get() = _binding!!

    private val svm: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecViewBinding.inflate(inflater, container, false)
        val view = binding.root

        svm.photoList.observe(viewLifecycleOwner) { list ->
            list?.let {
                val adapter = RecViewAdapter(it)
                binding.recyclerView.adapter = adapter
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}