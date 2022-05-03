package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.app.databinding.ActivityCharacterDetailsBinding

class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val index = intent.getIntExtra("index",0)
        val name = intent.getStringExtra("name")
        val image = intent.getStringExtra("image")

        binding.tvNameDetails.setText(name)
        Glide.with(this).load(image).into(binding.ivCharacterDetails);

    }
}