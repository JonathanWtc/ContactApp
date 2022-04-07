package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityAddNameBinding

class ActivityAddName : AppCompatActivity() {

    private lateinit var binding: ActivityAddNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // al hacer click al botón y los editText no estén vacíos volver al activity principal con los datos agregados
        binding.btnAdd.setOnClickListener() {
            val intent = Intent()

            if (binding.etxtNameAdd.text.isEmpty() && binding.etxtNumberAdd.text.isEmpty()) {
                Toast.makeText(this, "Ingrese nombre y numero para agregar", Toast.LENGTH_SHORT)
                    .show()
            } else if (binding.etxtNameAdd.text.isEmpty()) {
                Toast.makeText(this, "Falta nombre", Toast.LENGTH_SHORT).show()
            } else if (binding.etxtNumberAdd.text.isEmpty()) {
                Toast.makeText(this, "Falta numero", Toast.LENGTH_SHORT).show()
            } else {
                if (binding.etxtImageUrl.text.isEmpty()) {
                    intent.putExtra("NAME", binding.etxtNameAdd.text)
                    intent.putExtra("NUMBER", binding.etxtNumberAdd.text)
                    intent.putExtra(
                        "URL",
                        "https://cdn4.vectorstock.com/i/1000x1000/59/33/person-icon-in-flat-style-man-symbol-vector-21095933.jpg"
                    )
                    setResult(RESULT_OK, intent)
                    finish()
                    Toast.makeText(this, "Se agrego nuevo nombre sin foto", Toast.LENGTH_SHORT)
                        .show()
                } else { // volver y poner el extra con el nombre NAME del contenido de los editText
                    intent.putExtra("NAME", binding.etxtNameAdd.text)
                    intent.putExtra("NUMBER", binding.etxtNumberAdd.text)
                    intent.putExtra("URL", binding.etxtImageUrl.text)
                    setResult(RESULT_OK, intent)
                    finish()
                    Toast.makeText(this, "Se agrego nuevo nombre", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}