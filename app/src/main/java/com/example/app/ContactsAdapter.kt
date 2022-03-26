package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface ContactListener {
    fun onClick(index: Int, model: ModelList)
}
class ContactsAdapter(private val adaptList: List<ModelList>, private val contactListener: ContactListener): RecyclerView.Adapter<ContactsAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val contact = adaptList[position]
        holder.itemView.setOnClickListener {
            contactListener.onClick(position, contact)
        }
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return adaptList.size
    }

    class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {

        val txtName = view.findViewById<TextView>(R.id.txtName)
        val txtNumber = view.findViewById<TextView>(R.id.txtNumber)

        fun bind(contact: ModelList) {
            txtName.text = contact.name
            txtNumber.text = contact.number.toString()
        }
    }
}
