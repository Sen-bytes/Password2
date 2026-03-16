package com.example.password

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged

class Pass : AppCompatActivity() {
    private val MiViewModel: PassViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass)

        val et = findViewById<EditText>(R.id.etContra)
        val tv = findViewById<TextView>(R.id.tvVerificacion)

        MiViewModel.text.observe(this) { Seguridad ->
            tv.text = Seguridad
        }

        et.doOnTextChanged { text, start, before, count ->
            MiViewModel.setPass(text.toString())
        }

    }
}