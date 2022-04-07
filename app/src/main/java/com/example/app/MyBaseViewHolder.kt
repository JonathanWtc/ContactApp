package com.example.app

import android.view.View
import androidx.recyclerview.widget.RecyclerView

//sera una extension que usaremos cuando creemos el adaptador
abstract class MyBaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T, position: Int)
}