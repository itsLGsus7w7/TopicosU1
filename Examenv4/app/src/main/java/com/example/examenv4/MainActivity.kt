package com.example.examenv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRegister:Button=findViewById(R.id.buttonRegister)

        buttonRegister.setOnClickListener {
            var registerIntent: Intent=Intent(this,RegisterActivity::class.java)
            startActivity(registerIntent)
        }

        val buttonExit = findViewById<Button>(R.id.buttonExit)
        buttonExit.setOnClickListener {
            finish() // Cierra la actividad y finaliza la aplicación
        }
    }
}