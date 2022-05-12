package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemPokemonBinding
import com.example.app.model.Pokemon

class PokemonAdapter(val pokemonList: List<Pokemon>):RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {


    inner class PokemonViewHolder(val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        with(holder){
            with(pokemonList[position]){
                binding.tvPokemonName.text = name
            }
        }
    }

    override fun getItemCount(): Int = pokemonList.size
}