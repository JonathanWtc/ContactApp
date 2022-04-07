package com.example.app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val contextAdapter : Context, val listaDatos : List<MyListModel>):RecyclerView.Adapter<MyBaseViewHolder<*>>(){
    //Método donde inflaremos las vistas que va a contener los datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBaseViewHolder<*> {
        return MyViewHolder(LayoutInflater.from(contextAdapter).inflate(R.layout.my_item_recyclerview, parent, false))
    }

    //Método quien agarrara la información que le mandamos de la lista y la va poner a cada uno de los elementos.
    // con el formato que inflamos con el onCreateViewHolder.
    override fun onBindViewHolder(holder: MyBaseViewHolder<*>, position: Int) {
        when(holder){
            is MyViewHolder -> holder.bind(listaDatos[position],position)
            else -> throw IllegalArgumentException("Se olvido pasar el viewholder en el bind")
        }
    }
    //Método que devolverá de la lista de datos la cantidad que tiene que inflar.
    override fun getItemCount(): Int {
        return listaDatos.size
    }
    inner class MyViewHolder(itemView : View):MyBaseViewHolder<MyListModel>(itemView){
        val txtNombre = itemView.findViewById<TextView>(R.id.txtNombre)
        val txtNumber = itemView.findViewById<TextView>(R.id.txtNumero)
        var img_circle = itemView.findViewById<CircleImageView>(R.id.img_circle)

        override fun bind(item: MyListModel, position: Int) {
            //usamos el Glide para cargar con el adaptador la imagen y ponerla dentro de CircleImageView
            Glide.with(contextAdapter).load(item.imagen).into(img_circle)
            txtNombre.text = item.nombre
            txtNumber.text = item.numero.toString()
        }

    }
}