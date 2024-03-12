package com.example.gato

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Representación del tablero de juego (3x3)
    private val tablero = Array(3) { IntArray(3) }

    // Jugador actual (1 para X, -1 para O)
    private var jugadorActual = 1

    // TextView para mostrar el turno del jugador
    private lateinit var textTurno: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar el tablero
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                tablero[i][j] = 0
            }
        }

        // Obtener referencias a los elementos de la interfaz de usuario
        textTurno = findViewById(R.id.textTurno)

        // Actualizar el TextView para mostrar el turno del jugador actual
        actualizarTurno()

        // Configurar onClickListener para cada botón del tablero
        val buttons = arrayOf<Button>(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )

        for (button in buttons) {
            button.setOnClickListener {
                // Obtener el índice del botón
                val index = buttons.indexOf(button)
                // Realizar la jugada
                jugar(index / 3, index % 3)
            }
        }

        // Configurar onClickListener para el botón de reiniciar juego
        val buttonReiniciar: Button = findViewById(R.id.buttonReiniciar)
        buttonReiniciar.setOnClickListener {
            reiniciarJuego()
        }
    }

    // Función para realizar una jugada en la posición (fila, columna) del tablero
    private fun jugar(fila: Int, columna: Int) {
        if (tablero[fila][columna] == 0) { // Si la celda está vacía
            tablero[fila][columna] = jugadorActual // Asignar el jugador actual a la celda
            actualizarBoton(fila, columna) // Actualizar el botón en la interfaz de usuario
            if (hayGanador()) { // Verificar si hay un ganador
                mostrarMensaje("¡Jugador $jugadorActual gana!")
            } else if (tableroLleno()) { // Verificar si hay empate
                mostrarMensaje("¡Empate!")
            } else { // Cambiar al siguiente jugador
                jugadorActual *= -1
                actualizarTurno()
            }
        }
    }

    // Función para actualizar el TextView que muestra el turno del jugador actual
    private fun actualizarTurno() {
        textTurno.text = "Turno del jugador ${if (jugadorActual == 1) "X" else "O"}"
    }

    // Función para actualizar el estado del botón en la interfaz de usuario
    private fun actualizarBoton(fila: Int, columna: Int) {
        val buttons = arrayOf<Button>(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )
        val index = fila * 3 + columna
        buttons[index].text = if (jugadorActual == 1) "X" else "O"
        buttons[index].isEnabled = false // Desactivar el botón después de la jugada
    }

    // Función para verificar si hay un ganador
    private fun hayGanador(): Boolean {
        // Verificar filas y columnas
        for (i in 0 until 3) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2] && tablero[i][0] != 0) {
                return true
            }
            if (tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i] && tablero[0][i] != 0) {
                return true
            }
        }
        // Verificar diagonales
        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && tablero[0][0] != 0) {
            return true
        }
        if (tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0] && tablero[0][2] != 0) {
            return true
        }
        return false
    }

    // Función para verificar si el tablero está lleno (empate)
    private fun tableroLleno(): Boolean {
        for (fila in tablero) {
            for (celda in fila) {
                if (celda == 0) {
                    return false
                }
            }
        }
        return true
    }

    // Función para reiniciar el juego
    private fun reiniciarJuego() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                tablero[i][j] = 0 // Reiniciar el tablero
            }
        }
        val buttons = arrayOf<Button>(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )
        for (button in buttons) {
            button.text = "" // Limpiar el texto de los botones
            button.isEnabled = true // Habilitar los botones
        }
        jugadorActual = 1 // Restablecer el jugador actual a X
        actualizarTurno() // Actualizar el TextView del turno del jugador
    }

    // Función para mostrar un mensaje en la interfaz de usuario
    private fun mostrarMensaje(mensaje: String) {
        textTurno.text = mensaje
    }
}
