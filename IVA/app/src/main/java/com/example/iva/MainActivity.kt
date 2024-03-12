package com.example.iva

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPriceWithIVA = findViewById<EditText>(R.id.editTextPriceWithIVA)
        val textViewResultPriceWithoutIVA = findViewById<TextView>(R.id.textViewResultPriceWithoutIVA)
        val textViewResultIVA = findViewById<TextView>(R.id.textViewResultIVA)
        val buttonCalculate = findViewById<Button>(R.id.buttonCalculate)
        val buttonClear = findViewById<Button>(R.id.buttonClear)

        buttonCalculate.setOnClickListener {
            // Obtener el precio con IVA ingresado por el usuario
            val priceWithIVA = editTextPriceWithIVA.text.toString().toDoubleOrNull()

            // Verificar si se ingresó un valor válido
            if (priceWithIVA != null) {
                // Calcular el precio sin IVA y el IVA
                val priceWithoutIVA = priceWithIVA / 1.16
                val IVA = priceWithIVA - priceWithoutIVA

                // Mostrar los resultados en los TextView correspondientes
                textViewResultPriceWithoutIVA.text = String.format("%.2f", priceWithoutIVA)
                textViewResultIVA.text = String.format("%.2f", IVA)
            }
        }

        buttonClear.setOnClickListener {
            // Limpiar los campos de texto
            editTextPriceWithIVA.text.clear()
            textViewResultPriceWithoutIVA.text = ""
            textViewResultIVA.text = ""
        }
    }
}
