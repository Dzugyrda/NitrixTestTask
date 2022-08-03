package com.example.nitrixtesttask.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.adapters.VideosAdapter
import com.example.nitrixtesttask.ui.VideosActivity
import com.example.nitrixtesttask.ui.VideosViewModel
import kotlinx.android.synthetic.main.videos_list_fragment.*

class VideosFragment : Fragment(R.layout.videos_list_fragment) {
    lateinit var videosAdapter: VideosAdapter
    lateinit var videosViewModel: VideosViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        videosViewModel = (activity as VideosActivity).viewModel
        setupRecyclerView()
        observeVideos()
    }

    private fun observeVideos() {
        videosViewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            when {
                viewState.isLoading -> {}
                viewState.isError -> {}
                viewState.isSuccess && viewState.videos?.isNotEmpty() == true -> {
                    videosAdapter.setList(viewState.videos)
                }
                viewState.videos?.isEmpty() == true -> {}
            }

        }
    }

    private fun setupRecyclerView() {
        videosAdapter = VideosAdapter()
        rvVideos.apply {
            adapter = videosAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


}