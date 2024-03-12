package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var nombre : EditText
    lateinit var ok: Button
    lateinit var saludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.nombre)
        ok =findViewById(R.id.ok)
        saludo =findViewById(R.id.saludo)

    } // Termina metodo OnCreate

    fun ConstruyeSaludo(v:View){

        if(!nombre.text.toString().isEmpty()){
            var construye = "Hola " + nombre.text.toString() + " ¿Cómo estás? "
            saludo.text = construye

        } // Termina el if
        else{
            var alerta = AlertDialog.Builder(this)
                .setTitle("Error!")
                .setMessage("El Nombre está vacio")
            alerta.show()
        }
    } // Termina la funcion construyeSaludo

    fun Borrar(v:View){

        if(!saludo.text.toString().isEmpty()){
            saludo.text = ""
            nombre.setText("")

        } // Termina el if
        else{
            var alerta = AlertDialog.Builder(this)
                .setTitle("Error!")
                .setMessage("El Nombre está vacio")
            alerta.show()
        }
    } // Termina la funcion borrar
}
