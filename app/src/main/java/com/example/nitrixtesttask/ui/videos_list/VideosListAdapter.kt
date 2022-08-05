package com.example.nitrixtesttask.ui.videos_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.repository.api.Constants
import com.example.nitrixtesttask.ui.videos_list.model.VideoItem
import kotlinx.android.synthetic.main.video_list_item.view.*


class VideosListAdapter : ListAdapter<VideoItem, VideosListAdapter.VideosViewHolder>(
    object : DiffUtil.ItemCallback<VideoItem>() {
        override fun areItemsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
            return oldItem.prevImageUrl == newItem.prevImageUrl
        }

        override fun areContentsTheSame(oldItem: VideoItem, newItem: VideoItem): Boolean {
            return oldItem.prevImageUrl == newItem.prevImageUrl
        }

    }
) {

    inner class VideosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideosViewHolder {
        return VideosViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.video_list_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        val video = currentList[position]
        holder.itemView.apply {
            ivVideoPreview.setOnClickListener {
                findNavController().navigate(
                    VideosListFragmentDirections.actionVideosListFragmentToVideoFragment(video.id)
                )
            }
            Glide.with(this).load(Constants.BASE_IMAGE_URL + video.prevImageUrl)
                .fitCenter()
                .into(ivVideoPreview)
            tvVideoTitle.text = video.title
            tvVideoSubtitle.text = video.subtitle
            tvVideoDesc.text = video.description
        }
    }

}