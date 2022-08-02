package com.example.nitrixtesttask.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.models.VideoResponse
import com.example.nitrixtesttask.models.VideoResponseItem
import com.example.nitrixtesttask.util.Constants.Companion.BASE_IMAGE_URL
import kotlinx.android.synthetic.main.video_list_item.view.*

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

    var videosList = emptyList<VideoResponseItem>()

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

    override fun getItemCount(): Int {
        return videosList.size
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(this).load(BASE_IMAGE_URL + videosList[position].thumb).centerCrop()
                .into(ivVideoPreview)
            tvVideoTitle.text = videosList[position].title
            tvVideoSubtitle.text = videosList[position].subtitle
            tvVideoDesc.text = videosList[position].description
            setOnClickListener {
                findNavController().navigate(R.id.action_videosListFragment_to_videoFragment)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<VideoResponseItem>) {
        videosList = list
        notifyDataSetChanged()
    }

}