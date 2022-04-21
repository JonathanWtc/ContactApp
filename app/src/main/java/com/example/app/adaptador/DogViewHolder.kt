package com.example.app.adaptador

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

// al ViewHolder recibira una vista que vamos a pintar
class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDogBinding.bind(view)

    //creamos el metodo que va a unir, recibira una imagen que es string
    fun bind(image: String) {
        // El picasso convertita la url en imagen para mostrarla en la ImageView del item_dog
        Picasso.get().load(image).into(binding.ivDog)
    }
}