package com.example.examen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var buttonBackToMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonBackToMain = findViewById(R.id.buttonBackToMain)

        buttonRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Validar que el nombre de usuario y la contraseña no estén vacíos
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Registrar usuario y contraseña
                registerUser(username, password)

                // Abrir la actividad de bienvenida después de registrar
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                // Mostrar mensaje de error si el nombre de usuario o la contraseña están vacíos
                Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        buttonBackToMain.setOnClickListener {
            // Regresar a la actividad de inicio de sesión al hacer clic en el botón "Volver al menú principal"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun registerUser(username: String, password: String) {
        // Obtener la instancia de SharedPreferences para almacenar los datos del usuario
        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Obtener el conjunto actual de usuarios y contraseñas
        val users = sharedPreferences.getStringSet("users", HashSet()) ?: HashSet()

        // Agregar el nuevo usuario y contraseña al conjunto
        users.add("$username|$password")

        // Guardar el conjunto actualizado en SharedPreferences
        editor.putStringSet("users", users)
        editor.apply()
    }
}
