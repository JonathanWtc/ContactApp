package com.example.app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.databinding.ItemCharacterBinding
import com.example.app.model.Character

//crear adaptador, implementar sus miembros, crear el viewHolder
class CharacterAdapter(private var characterList: List<Character>, val onclickListener: OnClick) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    interface OnClick{
        fun onClickItem(position: Int, model: Character)
    }

    //////////////////////////// VIEW HOLDER DE PERSONAJES /////////////////////////////////////////
    inner class CharacterViewHolder(val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)


    //////////////////////////// METODOS DEL ADAPTADOR PERSONAJES //////////////////////////////////
    //encargado de crear el viewHolder, hace referencia al item_character
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    // encargado de poder obtener/poner la informacion de un objeto del arrego en una posision indicada
    override fun onBindViewHolder(
        holderCharacter: CharacterAdapter.CharacterViewHolder,
        position: Int
    ) {
        with(holderCharacter) {
            with(characterList[position]) {

                binding.tvId.text = id
                binding.tvName.text = name
                binding.tvStatus.text = status
                binding.tvSpecies.text = species
                binding.tvGender.text = gender
                Glide.with(itemView.context).load(image).into(binding.ivCharacter);
                binding.tvEpisode.text = episode.size.toString()
                binding.tvNameOrigin.text = origin.name

                //Evento click
                var characterPosition = characterList[position]
                itemView.setOnClickListener{onclickListener.onClickItem(position, characterPosition)}
            }
        }
    }

    override fun getItemCount(): Int = characterList.size
}