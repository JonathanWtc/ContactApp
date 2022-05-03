package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.app.adapter.EpisodesAdapter
import com.example.app.databinding.ActivityCharacterDetailsBinding
import com.example.app.model.Origin

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding
    lateinit var episodesAdapter: EpisodesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val index = intent.getIntExtra("index",0)
        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")
        val episodes = intent.getStringArrayListExtra("episodes")
        val origin = intent.getSerializableExtra("origin") as Origin

        binding.tvNameDetails.setText(name)
        Glide.with(this).load(image).into(binding.ivCharacterDetails)

        if (episodes != null) {
            episodesAdapter = EpisodesAdapter(episodes.toList())
        }

        binding.rvEpisodesDetails.adapter = episodesAdapter
        episodesAdapter.notifyDataSetChanged()


        binding.tvNamePlanet.text = origin.name
        binding.tvUrlPlanet.text = origin.url
    }
}