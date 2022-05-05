package com.example.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.databinding.ItemContactBinding

class ContactAdapter(
    val contactList: List<MyListModel>,
    private val onClick: OnClick
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // Se crea la interface con funciones onClick y onClickLong
    interface OnClick {
        fun onClickLongItemDelete(index: Int, nombre: String)
        fun onClickItemEdit(index: Int, model: MyListModel)
    }

    ////////////////////////////////////// VIEW HOLDER //////////////////////////////////////////////
    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    /////////////////////////////// METODOS DEL ADAPTADOR //////////////////////////////////////////
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        with(holder) {
            with(contactList[position]) {
                binding.txtNombre.text = nombre
                binding.txtNumero.text = numero.toString()
                Glide.with(itemView).load(imagen).into(binding.imgCircle)

                // Evento click largo para eliminar contacto
                itemView.setOnLongClickListener {
                    onClick.onClickLongItemDelete(position, nombre)
                    return@setOnLongClickListener true
                }
                //evento click para editar contacto
                val nombres = contactList[position]
                itemView.setOnClickListener { onClick.onClickItemEdit(position, nombres) }
            }
        }
    }

    override fun getItemCount(): Int = contactList.size
}