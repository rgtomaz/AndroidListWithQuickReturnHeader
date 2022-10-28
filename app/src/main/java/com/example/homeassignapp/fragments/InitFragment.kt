package com.example.homeassignapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.homeassignapp.databinding.FragmentInitBinding

class InitFragment : Fragment() {

    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentInitBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnShowList.setOnClickListener { navToListFragment() }
        binding.btnShowRecView.setOnClickListener { navToRecViewFragment() }

        return view
    }

    private fun navToListFragment() {
        InitFragmentDirections.actionInitFragmentToListFragment().let { action ->
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    private fun navToRecViewFragment() {
        InitFragmentDirections.actionInitFragmentToRecViewFragment().let { action ->
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}