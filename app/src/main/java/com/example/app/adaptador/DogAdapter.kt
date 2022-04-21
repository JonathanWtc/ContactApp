package com.example.app.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R

//el adaptador recibira una lista de imagenes de tipo lista de string
class DogAdapter(private val images: List<String>) : RecyclerView.Adapter<DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        //Retornara el titular de la vista y lo inflara en el item
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        //colocamos la imagen con su posición en una variable
        val item: String = images[position]
        holder.bind(item)
    }
    //Devolverá el tamaños de la lista de imágenes
    override fun getItemCount(): Int {
        return images.size
    }
}