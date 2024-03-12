package com.example.areafiguras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class windowcuadrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windowcuadrado)

        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)
        val calcularCuadradoButton: Button = findViewById(R.id.calcularCuadrado)
        val ladoEditText: EditText = findViewById(R.id.cuadradolado)
        val areaTextView: TextView = findViewById(R.id.cuadradoarea)

        mainMenuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        calcularCuadradoButton.setOnClickListener {
            val ladoString = ladoEditText.text.toString()
            if (ladoString.isNotEmpty()) {
                val lado = ladoString.toFloat()
                val area = lado * lado
                areaTextView.text = "El área del cuadrado es: $area"
            } else {
                areaTextView.text = "Por favor, ingrese la medida del lado del cuadrado."
            }
        }
    }
}
