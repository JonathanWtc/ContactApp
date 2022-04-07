package com.example.app

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toAdapt: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toAdapt = MyAdapter(this, NameList.names, object : MyAdapter.MyClick {
            override fun myClickLongItem(index: Int, nombre: String) {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Eliminar contacto")
                builder.setMessage("Esta seguro de eliminar a $nombre")
                builder.setPositiveButton("Si") { dialogInterface: DialogInterface, i: Int ->
                    NameList.names.removeAt(index)
                    toAdapt.notifyDataSetChanged()
                }
                builder.setNegativeButton("Cancelar") { dialogInterface: DialogInterface, i: Int -> }
                builder.show()
            }
        })
        binding.myRecyclerView.adapter = toAdapt
    }
}