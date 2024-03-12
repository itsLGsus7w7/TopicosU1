package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonExit = findViewById<Button>(R.id.buttonExit)

        buttonLogin.setOnClickListener {
            // Aquí debes implementar la lógica para verificar el usuario y la contraseña
            // Si las credenciales son válidas, puedes abrir la actividad de bienvenida
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        buttonRegister.setOnClickListener {
            // Abre la actividad de registro cuando se hace clic en el botón de registro
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        buttonExit.setOnClickListener {
            // Cierra la aplicación cuando se hace clic en el botón de salida
            finish()
        }
    }
}
