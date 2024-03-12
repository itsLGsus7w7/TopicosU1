package com.example.examenv4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonBackToMain:Button=findViewById(R.id.buttonBackToMain)

        buttonBackToMain.setOnClickListener {
            var backToMainIntent: Intent=Intent(this,MainActivity::class.java)
            startActivity(backToMainIntent)
        }
    }
}
