package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemEpisodesBinding

class EpisodesAdapter(private val episodes: List<String>): RecyclerView.Adapter<EpisodesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val episode = episodes[position]
        holder.bind(episode)
    }

    override fun getItemCount(): Int {
        return episodes.size
    }


    inner class ViewHolder(private val binding: ItemEpisodesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(value: String) {
            binding.tvLinkEpisodes.text = value
        }
    }
}