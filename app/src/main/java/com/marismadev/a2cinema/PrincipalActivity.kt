package com.marismadev.a2cinema

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    // Método para manejar el clic del botón
    fun irACreditActivity(view: View) {
        val editTextUsuario = findViewById<EditText>(R.id.editTextUsuario)
        val nombreUsuario = editTextUsuario.text.toString()

        val intent = Intent(this, CreditActivity::class.java)
        intent.putExtra("NOMBRE_USUARIO", nombreUsuario)
        startActivity(intent)
    }
}