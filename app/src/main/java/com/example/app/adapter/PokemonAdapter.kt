package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemPokemonBinding
import com.example.app.model.Pokemon
import com.example.app.model.PokemonList

class PokemonAdapter(private var pokemonList: List<Pokemon>):RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    inner class PokemonViewHolder(val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        with(holder){
            binding.tvPokemonName.text = pokemonList[position].name
            binding.tvPokemonUrl.text = pokemonList[position].url
        }
    }

    override fun getItemCount(): Int = pokemonList.size
}