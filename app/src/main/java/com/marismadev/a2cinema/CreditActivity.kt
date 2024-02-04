package com.marismadev.a2cinema

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CreditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Obtén el nombre de usuario de la MainActivity
        val nombreUsuario = intent.getStringExtra("NOMBRE_USUARIO")

        // Configura el texto de bienvenida con el nombre de usuario
        val textViewBienvenida = findViewById<TextView>(R.id.textViewBienvenida)
        textViewBienvenida.text = "Usuario $nombreUsuario, estás usando la versión 1 de la aplicación."

        // Configura el botón de contacto
        val btnContactar = findViewById<Button>(R.id.btnContactar)
        btnContactar.setOnClickListener {
            enviarCorreoConsulta()
        }
    }


    private fun enviarCorreoConsulta() {
        val asunto = "Consulta de la app MiApp" // Reemplaza "MiApp" con el nombre de tu aplicación
        val correoIntent = Intent(Intent.ACTION_SENDTO)
        correoIntent.data = Uri.parse("mailto:") // Solo aplicaciones de correo electrónico
        correoIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tudirecciondecorreo@example.com"))
        correoIntent.putExtra(Intent.EXTRA_SUBJECT, asunto)

        if (correoIntent.resolveActivity(packageManager) != null) {
            startActivity(correoIntent)
        }
    }

}