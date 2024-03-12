package com.example.ventanas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ventana2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana2)


        val button2: Button =findViewById(R.id.button2)

        button2.setOnClickListener {
            var v2: Intent = Intent(this,MainActivity::class.java)
            startActivity(v2)
        }
    }
}