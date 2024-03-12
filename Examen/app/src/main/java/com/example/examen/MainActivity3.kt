package com.example.examen

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Recuperar el nombre de usuario de los datos de inicio de sesión
        val username = intent.getStringExtra("username")

        // Mostrar el nombre de usuario en el TextView
        val textUserName = findViewById<TextView>(R.id.textUserName)
        textUserName.text = "Usuario: $username"
    }
}
