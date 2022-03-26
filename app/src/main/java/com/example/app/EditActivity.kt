package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityEditBinding
import com.example.app.databinding.ActivityMainBinding

class EditActivity : AppCompatActivity() {
    private lateinit var binding : ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra("position",0)
        val name = intent.getStringExtra("name")
        val number = intent.getIntExtra("number", 0)

        binding.eTxtAddName.setText(name)
        binding.eTxtAddNumber.setText(number.toString())

        binding.btnAdd.setOnClickListener {
            val intent = Intent()
            intent.putExtra("INDEX", index)
            intent.putExtra("NAME", binding.eTxtAddName.text)
            intent.putExtra("NUMBER", binding.eTxtAddNumber.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}