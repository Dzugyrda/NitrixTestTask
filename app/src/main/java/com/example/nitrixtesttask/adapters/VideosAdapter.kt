package com.example.nitrixtesttask.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.nitrixtesttask.R
import kotlinx.android.synthetic.main.video_list_item.view.*

class VideosAdapter : RecyclerView.Adapter<VideosAdapter.VideosViewHolder>() {

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
        return 15
    }


    override fun onBindViewHolder(holder: VideosViewHolder, position: Int) {
        holder.itemView.apply {
            ivVideoPreview.setImageResource(R.drawable.vwgti)
            tvVideoTitle.text = "Volkswagen GTI Review"
            tvVideoSubtitle.text = "By Garage419"
            tvVideoDesc.text =
                "The Smoking Tire heads out to Adams Motorsports Park in Riverside, CA to test the most requested car of 2010, the Volkswagen GTI. Will it beat the Mazdaspeed3's standard-setting lap time? Watch and see..."
            setOnClickListener {
                findNavController().navigate(R.id.action_videosFragment_to_videoFragment)
            }
        }
    }

}