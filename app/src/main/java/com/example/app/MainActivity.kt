package com.example.app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var contactAdapter: ContactAdapter
    private val myRequestCode = 1
    private val myRequestCodeEdit = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactAdapter = ContactAdapter(NameList.names, object : ContactAdapter.OnClick {

            //funcion de la interfaz "click largo para eliminar"
            override fun onClickLongItemDelete(index: Int, nombre: String) {
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setTitle("Eliminar contacto")
                builder.setMessage("Esta seguro de eliminar a $nombre")
                builder.setPositiveButton("Si") { dialogInterface: DialogInterface, i: Int ->
                    NameList.names.removeAt(index)
                    contactAdapter.notifyDataSetChanged()
                }
                builder.setNegativeButton("Cancelar") { dialogInterface: DialogInterface, i: Int -> }
                builder.show()

                // eliminar sin AlertDialog
                //NameList.names.removeAt(index)
                //contactAdapter.notifyDataSetChanged()
            }

            //funcion de la intrefaz "click para editar"
            override fun onClickItemEdit(index: Int, model: MyListModel) {
                Toast.makeText(this@MainActivity, "Editar contacto", Toast.LENGTH_SHORT)
                    .show()
                // Intentar = pasar de esta actividad a la actividad de edicion
                val intent = (Intent(this@MainActivity, EditActivity::class.java))
                //poniendo el index en "posision", el nombre en "name", etc
                intent.putExtra("position", index)
                intent.putExtra("image",model.imagen)
                intent.putExtra("name", model.nombre)
                intent.putExtra("number", model.numero)
                startActivityForResult(intent, myRequestCodeEdit)
            }
        })
        binding.myRecyclerView.adapter = contactAdapter

        // 2 // Iniciamos setOnClickListener con startActivityForResult e Intent
        // para pasar al segundo activity y esperar el resultado
        binding.btnEnterAdd.setOnClickListener() {
            startActivityForResult(Intent(this, ActivityAddName::class.java), myRequestCode)
        }
    }

    //crear funcion que devolvera el resultado del activity _add_name(ActivityAddName)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == myRequestCode) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    val dataResponseName = data.extras?.get("NAME").toString()
                    val dataResponseNumber = data.extras?.get("NUMBER").toString()
                    val dataResponseUrl = data.extras?.get("URL").toString()
                    NameList.names.add(
                        MyListModel(
                            nombre = dataResponseName,
                            imagen = dataResponseUrl,
                            numero = dataResponseNumber.toInt()
                        )
                    )
                    contactAdapter.notifyItemInserted(NameList.names.size)
                }
            } else {
                Toast.makeText(this, "No se agrego contenido", Toast.LENGTH_SHORT).show()
            }
        }

        if (requestCode == myRequestCodeEdit) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    //Igualar a la variable el dato extra obtenido de "INDEX" y demas
                    val index = data.extras?.get("INDEX") as Int
                    val name = data.extras?.get("NAME").toString()
                    val number = data.extras?.get("NUMBER").toString().toInt()
                    //igualar la variable al contenido de la lista en el index indicado
                    NameList.names[index].nombre = name
                    NameList.names[index].numero = number
                    contactAdapter.notifyDataSetChanged()

                    Toast.makeText(this, "Se Edito $name con numero $number", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(this, "No se Edito contacto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}