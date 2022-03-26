package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var toAdapt : ContactsAdapter
    private val myRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toAdapt = ContactsAdapter(ContactList.list)
        binding.recyclerContact.adapter = toAdapt

        binding.btnFloatingAdd.setOnClickListener(){
            startActivityForResult(Intent(this, ActivityAddContact::class.java),myRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (myRequestCode == requestCode){
            if (resultCode == RESULT_OK){
                if (data != null){
                    val dataResponse = data.extras?.get("NAME").toString()
                    var dataResponse2 = data.extras?.get("NUMBER").toString()
                    if (dataResponse2.isEmpty()){
                        dataResponse2="0"
                    }
                    ContactList.list.add(ModelList(name = dataResponse, number = dataResponse2.toInt()))
                    toAdapt.notifyItemInserted(ContactList.list.size - 1)
                    Toast.makeText(this, "Agregaste un nuevo contacto", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "No se agrego contacto", Toast.LENGTH_SHORT).show()
            }
        }
    }
}