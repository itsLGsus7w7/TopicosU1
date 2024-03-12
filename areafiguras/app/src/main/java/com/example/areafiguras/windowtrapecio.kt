package com.example.areafiguras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class windowtrapecio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windowtrapecio)

        val calcularTrapecioButton: Button = findViewById(R.id.calcularTrapecio)
        val trapecioAreaTextView: TextView = findViewById(R.id.trapecioarea)
        val trapecioBase1EditText: EditText = findViewById(R.id.trapeciobase1)
        val trapecioBase2EditText: EditText = findViewById(R.id.trapeciobase2)
        val trapecioAlturaEditText: EditText = findViewById(R.id.trapeciobasealtura)

        calcularTrapecioButton.setOnClickListener {
            // Obtener los valores de las bases y la altura del trapecio
            val base1 = trapecioBase1EditText.text.toString().toDoubleOrNull() ?: 0.0
            val base2 = trapecioBase2EditText.text.toString().toDoubleOrNull() ?: 0.0
            val altura = trapecioAlturaEditText.text.toString().toDoubleOrNull() ?: 0.0

            // Calcular el área del trapecio
            val area = (base1 + base2) * altura / 2

            // Mostrar el resultado en el TextView
            trapecioAreaTextView.text = "El área del trapecio es: $area"
        }

        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)

        mainMenuButton.setOnClickListener {
            var v1: Intent = Intent(this, MainActivity::class.java)
            startActivity(v1)
        }
    }
}
