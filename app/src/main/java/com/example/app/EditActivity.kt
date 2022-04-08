package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //obtener contenido de la posicion, nombre y numero
        val index = intent.getIntExtra("position", 0)
        val name = intent.getStringExtra("name")
        val number = intent.getIntExtra("number", 0)

        //colocar en editText de editActivity lo obtenido anteriormente
        binding.etxtNameEdit.setText(name)
        binding.etxtNumberEdit.setText(number.toString())

        //al dar click poner el index en "INDEX", el etxtNameEdit en "NAME" el contenido de los editText del editActivity
        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            if (binding.etxtNameEdit.text.isEmpty() || binding.etxtNumberEdit.text.isEmpty()) {
                Toast.makeText(this, "No puede editar vacio", Toast.LENGTH_SHORT).show()
            } else {
                intent.putExtra("INDEX", index)
                intent.putExtra("NAME", binding.etxtNameEdit.text)
                intent.putExtra("NUMBER", binding.etxtNumberEdit.text)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}