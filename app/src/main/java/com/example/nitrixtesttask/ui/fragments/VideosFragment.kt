package com.example.nitrixtesttask.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.adapters.VideosAdapter
import com.example.nitrixtesttask.ui.VideosViewModel
import kotlinx.android.synthetic.main.videos_list_fragment.*

class VideosFragment : Fragment(R.layout.videos_list_fragment) {
    private val adapter: VideosAdapter = VideosAdapter()
    private val videosViewModel: VideosViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvVideos.adapter = adapter
        observeVideos()
    }

    private fun observeVideos() {
        videosViewModel.viewState.observe(viewLifecycleOwner) { viewState ->
            when {
                viewState.isLoading -> {}
                viewState.isError -> {}
                viewState.isSuccess && viewState.videos?.isNotEmpty() == true -> {
                    adapter.setList(viewState.videos)
                }
                viewState.videos?.isEmpty() == true -> {}
            }

        }
    }


}