package com.example.memorama

import android.os.Bundle
import android.widget.Button
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var cartaSeleccionada: ToggleButton? = null
    private var cartaAnterior: ToggleButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Obtener una referencia al botón de reinicio
        val botonReiniciar = findViewById<Button>(R.id.botonReiniciar)

        // Configurar OnClickListener para el botón de reinicio
        botonReiniciar.setOnClickListener {
            reiniciarJuego()
        }

        val cartas = listOf(
            findViewById<ToggleButton>(R.id.CardA1), findViewById(R.id.CardA2),
            findViewById(R.id.CardB1), findViewById(R.id.CardB2),
            findViewById(R.id.CardC1), findViewById(R.id.CardC2),
            findViewById(R.id.CardD1), findViewById(R.id.CardD2),
            findViewById(R.id.CardE1), findViewById(R.id.CardE2),
            findViewById(R.id.CardF1), findViewById(R.id.CardF2),
            findViewById(R.id.CardG1), findViewById(R.id.CardG2),
            findViewById(R.id.CardH1), findViewById(R.id.CardH2)
        )

        cartas.forEach { carta ->
            carta.setOnClickListener {
                if (carta.isChecked) {
                    manejarClicCarta(carta)
                }
            }
        }
    }

    private fun manejarClicCarta(carta: ToggleButton) {
        if (cartaSeleccionada == null) {
            cartaSeleccionada = carta
        } else if (cartaSeleccionada != null && cartaAnterior == null) {
            cartaAnterior = cartaSeleccionada
            cartaSeleccionada = carta

            if (carta.text == cartaAnterior?.text) {
                cartaSeleccionada?.isEnabled = false
                cartaAnterior?.isEnabled = false
                cartaSeleccionada = null
                cartaAnterior = null
            } else {
                // Si las cartas no coinciden, se deseleccionan después de un breve retraso
                cartaSeleccionada?.postDelayed({
                    cartaSeleccionada?.isChecked = false
                    cartaAnterior?.isChecked = false
                    cartaSeleccionada = null
                    cartaAnterior = null
                }, 500) // Retraso en milisegundos antes de ocultar las cartas
            }
        }
    }

    // Función para reiniciar el juego
    private fun reiniciarJuego() {
        val cartas = listOf(
            findViewById<ToggleButton>(R.id.CardA1), findViewById(R.id.CardA2),
            findViewById(R.id.CardB1), findViewById(R.id.CardB2),
            findViewById(R.id.CardC1), findViewById(R.id.CardC2),
            findViewById(R.id.CardD1), findViewById(R.id.CardD2),
            findViewById(R.id.CardE1), findViewById(R.id.CardE2),
            findViewById(R.id.CardF1), findViewById(R.id.CardF2),
            findViewById(R.id.CardG1), findViewById(R.id.CardG2),
            findViewById(R.id.CardH1), findViewById(R.id.CardH2)
        )

        // Restablecer el estado de cada carta
        cartas.forEach { carta ->
            carta.isChecked = false
            carta.isEnabled = true
        }

        // Limpiar las referencias de carta seleccionada y carta anterior
        cartaSeleccionada = null
        cartaAnterior = null
    }
}
