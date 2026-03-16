package com.example.password

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged // Importante agregar esta importación

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

        // NUEVO CÓDIGO: Escuchamos cada vez que el texto cambia en tiempo real
        et.doOnTextChanged { text, start, before, count ->
            // Se ejecuta cada vez que el usuario teclea o borra un carácter
            MiViewModel.setPass(text.toString())
        }

    }
}