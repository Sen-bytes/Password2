package com.example.password

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class Pass : AppCompatActivity() {
    private val MiViewModel: PassViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pass)

        val et = findViewById<EditText>(R.id.etContra)
        val btn = findViewById<Button>(R.id.btnEnvio)
        val tv = findViewById<TextView>(R.id.tvVerificacion)


        MiViewModel.text.observe(this) { Seguridad ->
            tv.text = Seguridad
        }
        btn.setOnClickListener { val pass = et.text.toString()
            MiViewModel.setPass(pass)
         }

    }
}