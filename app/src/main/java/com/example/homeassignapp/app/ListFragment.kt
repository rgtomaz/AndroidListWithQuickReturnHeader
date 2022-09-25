package com.example.homeassignapp.app

import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListView
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

        binding.listHeader.attachQuickReturn(binding.list)

        return view
    }

    private fun View.attachQuickReturn(listView: ListView) {
        val translationValueMin = y
        val translationValueMax = 0F

        val animatorShowView = ObjectAnimator.ofFloat(this, "translationY", translationValueMax).apply {
            duration = 500
        }

        val animatorHideView = ObjectAnimator.ofFloat(this, "translationY", translationValueMin).apply {
            duration = 500
        }

        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(p0: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (!animatorShowView.isRunning) animatorShowView.start()

                // TODO: check when the list is scrolling up or down and call animator accordingly
            }

            override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {}
        })
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