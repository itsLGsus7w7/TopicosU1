package com.example.precios2

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var nombreEditText: EditText
    private lateinit var edadEditText: EditText
    private lateinit var fechaNacEditText: EditText
    private lateinit var telefonoEditText: EditText
    private lateinit var radioH: RadioButton
    private lateinit var radioM: RadioButton
    private lateinit var videoGamesCheckBox: CheckBox
    private lateinit var futbolCheckBox: CheckBox
    private lateinit var gymCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de vistas
        nombreEditText = findViewById(R.id.editNombre)
        edadEditText = findViewById(R.id.editedad)
        fechaNacEditText = findViewById(R.id.FechaNac)
        telefonoEditText = findViewById(R.id.Telefono)
        radioH = findViewById(R.id.radioH)
        radioM = findViewById(R.id.radioM)
        videoGamesCheckBox = findViewById(R.id.videogames)
        futbolCheckBox = findViewById(R.id.futbol)
        gymCheckBox = findViewById(R.id.gym)

        // Configuración de clics en botones
        findViewById<Button>(R.id.Guardar).setOnClickListener {
            mostrarDatos()
        }

        findViewById<Button>(R.id.Limpiar).setOnClickListener {
            limpiarDatos()
        }
    }

    private fun mostrarDatos() {
        val nombre = nombreEditText.text.toString()
        val edad = edadEditText.text.toString()
        val fechaNac = fechaNacEditText.text.toString()
        val telefono = telefonoEditText.text.toString()
        val genero = when {
            radioH.isChecked -> "Hombre"
            radioM.isChecked -> "Mujer"
            else -> "No Especificado"
        }

        val hobbies = StringBuilder()
        if (videoGamesCheckBox.isChecked) {
            hobbies.append("Video juegos, ")
        }
        if (futbolCheckBox.isChecked) {
            hobbies.append("Fútbol, ")
        }
        if (gymCheckBox.isChecked) {
            hobbies.append("Gym, ")
        }

        val mensaje = "Nombre: $nombre\nEdad: $edad\nFecha de Nacimiento: $fechaNac\nTeléfono: $telefono\nGénero: $genero\nHobbies: ${hobbies.trimEnd().toString()}"

        AlertDialog.Builder(this)
            .setTitle("Datos")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", null)
            .show()
    }


    private fun limpiarDatos() {
        nombreEditText.text.clear()
        edadEditText.text.clear()
        fechaNacEditText.text.clear()
        telefonoEditText.text.clear()
        radioH.isChecked = false
        radioM.isChecked = false
        videoGamesCheckBox.isChecked = false
        futbolCheckBox.isChecked = false
        gymCheckBox.isChecked = false
    }
}
