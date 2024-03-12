package com.example.areafiguras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.PI

class windowcirculo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_windowcirculo)

        val mainMenuButton: Button = findViewById(R.id.mainMenuButton)
        val calcularCirculoButton: Button = findViewById(R.id.calcularCirculo)
        val radioEditText: EditText = findViewById(R.id.circuloradio)
        val circuloAreaTextView: TextView = findViewById(R.id.circuloarea)

        mainMenuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        calcularCirculoButton.setOnClickListener {
            val radioStr = radioEditText.text.toString()
            if (radioStr.isNotEmpty()) {
                val radio = radioStr.toDouble()
                val area = PI * radio * radio
                val areaFormateada = String.format("%.2f", area)
                circuloAreaTextView.text = "El área del círculo es: $areaFormateada"
            } else {
                circuloAreaTextView.text = "Ingrese el radio del círculo."
            }
        }
    }
}
