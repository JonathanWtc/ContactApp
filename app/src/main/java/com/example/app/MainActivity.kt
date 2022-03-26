package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
}