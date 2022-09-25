package com.example.homeassignapp.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.homeassignapp.databinding.FragmentListBinding
import com.example.homeassignapp.retrofit.Photo

class ListFragment : Fragment(), ListItemListener {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val svm: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        svm.photoList.observe(viewLifecycleOwner) { list ->
            list?.let {
                val adapter = ItemAdapter(requireContext(), it, this@ListFragment)
                binding.list.adapter = adapter
            }
        }

        return view
    }

    override fun onClickPhoto(item: Photo, position: Int) {
        Log.d("svm", position.toString())
        Log.d("svm", item.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}