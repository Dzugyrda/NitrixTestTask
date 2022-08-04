package com.example.nitrixtesttask.ui.videos_list

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nitrixtesttask.R
import kotlinx.android.synthetic.main.videos_list_fragment.*
import kotlinx.coroutines.launch

class VideosFragment : Fragment(R.layout.videos_list_fragment) {

    private val videosAdapter: VideosAdapter = VideosAdapter()
    private val videosViewModel: VideosViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeVideos()
    }

    private fun observeVideos() {
        lifecycleScope.launch {
            videosViewModel.viewState.collect { viewState ->
                when {
                    viewState.isLoading -> showLoading()
                    viewState.videos.isNotEmpty() -> {
                        hideLoading()
                        videosAdapter.setList(viewState.videos)
                    }
                    viewState.videos.isEmpty() -> showError("Videos not found")
                }
            }
        }
    }

    private fun setupRecyclerView() {
        rvVideos.apply {
            adapter = videosAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showLoading() {
        rvVideos.isVisible = false
        pbLoader.isVisible = true
    }

    private fun hideLoading() {
        rvVideos.isVisible = true
        pbLoader.isVisible = false
    }

    private fun showError(error: String) {
        rvVideos.isVisible = false
        pbLoader.isVisible = false
        tvError.isVisible = true
        tvError.text = error
    }
}