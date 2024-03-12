package com.example.areafiguras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.areafiguras.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioButtonTrapecio: RadioButton = findViewById(R.id.radioButtonTrapecio)

        radioButtonTrapecio.setOnClickListener {
            val trapecioIntent = Intent(this, windowtrapecio::class.java)
            startActivity(trapecioIntent)
        }


        val radioButtonCuadrado: RadioButton = findViewById(R.id.radioButtonCuadrado)

        radioButtonCuadrado.setOnClickListener {
            val cuadradoIntent = Intent(this, windowcuadrado::class.java)
            startActivity(cuadradoIntent)
        }


        val radioButtonCirculo: RadioButton = findViewById(R.id.radioButtonCirculo)

        radioButtonCirculo.setOnClickListener {
            val circuloIntent = Intent(this, windowcirculo::class.java)
            startActivity(circuloIntent)
        }


        val radioButtonTriangulo: RadioButton = findViewById(R.id.radioButtonTriangulo)

        radioButtonTriangulo.setOnClickListener {
            val trianguloIntent = Intent(this, windowtriangulo::class.java)
            startActivity(trianguloIntent)
        }


    }
}
