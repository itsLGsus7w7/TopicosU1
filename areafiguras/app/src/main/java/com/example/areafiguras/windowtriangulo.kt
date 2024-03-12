package com.example.areafiguras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.absoluteValue

class windowtriangulo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windowtriangulo)

        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)
        val calcularTrianguloButton: Button = findViewById(R.id.calculartriangulo)
        val alturaEditText: EditText = findViewById(R.id.trianguloaltura)
        val baseEditText: EditText = findViewById(R.id.triangulobase)
        val areaTextView: TextView = findViewById(R.id.trianguloarea)

        mainMenuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        calcularTrianguloButton.setOnClickListener {
            val altura = alturaEditText.text.toString().toDoubleOrNull()
            val base = baseEditText.text.toString().toDoubleOrNull()

            if (altura != null && base != null && altura > 0 && base > 0) {
                val area = (base * altura) / 2
                areaTextView.text = "El área del triángulo es: ${"%.2f".format(area)}"
            } else {
                areaTextView.text = "Por favor, ingrese valores válidos para la altura y la base."
            }
        }
    }
}
