package com.example.homeassignapp.app

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.homeassignapp.databinding.FragmentListBinding
import com.example.homeassignapp.retrofit.PhotoItem

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
        val translationValMin = y
        val translationValMax = 0F
        val up = 1
        val idle = 0
        val down = -1
        val animDuration = 300L
        var direction = idle
        var prevFirstVisibleItem = 0

        val animatorShowView = ObjectAnimator
            .ofFloat(this, "translationY", translationValMax)
            .apply { duration = animDuration }

        val animatorHideView = ObjectAnimator
            .ofFloat(this, "translationY", translationValMin)
            .apply { duration = animDuration }

        listView.setOnScrollListener(object : AbsListView.OnScrollListener {
            override fun onScroll(p0: AbsListView?, firstVisibleItem: Int, visibleItemCount: Int, totalItemCount: Int) {
                if (prevFirstVisibleItem < firstVisibleItem) direction = up
                if (prevFirstVisibleItem == firstVisibleItem) direction = idle
                if (prevFirstVisibleItem > firstVisibleItem) direction = down

                when (direction) {
                    up -> {
                        if (y != translationValMin && !animatorHideView.isRunning)
                            animatorHideView.start()
                    }
                    idle -> {}
                    down -> {
                        if (y != translationValMax && !animatorShowView.isRunning && firstVisibleItem > 0)
                            animatorShowView.start()
                    }
                }
                prevFirstVisibleItem = firstVisibleItem
            }

            override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {}
        })
    }

    private fun navToDetailsFrag() {
        ListFragmentDirections.actionListFragmentToDetailsFragment().let { action ->
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    override fun onClickPhoto(item: PhotoItem, position: Int) {
        svm.setPhotoItem(item)
        navToDetailsFrag()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}