package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val index = intent.getIntExtra("position",0)
        val name = intent.getStringExtra("name")
        val photo = intent.getStringExtra("url")

        binding.etxtNameEdit.setText(name)
        binding.etxtImageEdit.setText(photo)

        binding.btnEdit.setOnClickListener{
            val intent = Intent()
            intent.putExtra("INDEX",index)
            intent.putExtra("NAME", binding.etxtNameEdit.text)
            intent.putExtra("PHOTO", binding.etxtImageEdit.text)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}