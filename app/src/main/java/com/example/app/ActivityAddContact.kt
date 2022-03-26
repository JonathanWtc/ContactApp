package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityAddContactBinding
import com.example.app.databinding.ActivityMainBinding

class ActivityAddContact : AppCompatActivity() {

    private lateinit var binding: ActivityAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener(){
            val intent = Intent()

            if (binding.eTxtAddName.text.isEmpty() && binding.eTxtAddNumber.text.isEmpty()){
                Toast.makeText(this, "Falta informacion para guardar contacto", Toast.LENGTH_SHORT)
                    .show()
            }else if (binding.eTxtAddName.text.isEmpty()){
                Toast.makeText(this, "Ingrese el nombre", Toast.LENGTH_SHORT).show()
            }else if (binding.eTxtAddNumber.text.isEmpty()){
                Toast.makeText(this, "Ingrese numero", Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("NAME", binding.eTxtAddName.text)
                intent.putExtra("NUMBER", binding.eTxtAddNumber.text)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
        binding.btnBack.setOnClickListener(){
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}