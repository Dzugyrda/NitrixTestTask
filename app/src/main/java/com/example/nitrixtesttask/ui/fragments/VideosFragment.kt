package com.example.nitrixtesttask.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.adapters.VideosAdapter
import kotlinx.android.synthetic.main.videos_fragment.*

class VideosFragment : Fragment(R.layout.videos_fragment) {
    private val adapter: VideosAdapter = VideosAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvVideos.adapter = adapter
    }


}