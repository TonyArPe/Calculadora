package com.example.calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {

    private var currentNumber = StringBuilder()
    private var currentResult = 0.0
    private var currentOperator = ""

    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)
    }

    // Función para manejar clics en botones numéricos
    fun onNumberClick(view: View) {
        val button = view as Button
        val number = button.text.toString()
        currentNumber.append(number)
        textViewResult.text = currentNumber.toString()
    }

    // Función para manejar el clic en el botón de borrar (C)
    fun onClearClick(view: View) {
        currentNumber.clear()
        currentResult = 0.0
        currentOperator = ""
        textViewResult.text = "0"
    }

    // Función para manejar clics en botones de operaciones (por ejemplo, +, -, *, /)
    fun onOperatorClick(view: View) {
        val button = view as Button
        val operator = button.text.toString()

        if (currentNumber.isNotEmpty()) {
            currentOperator = operator
            currentResult = currentNumber.toString().toDouble()
            currentNumber.clear()
        }
    }

    // Función para manejar el clic en el botón de igual (=)
    fun onEqualClick(view: View) {
        if (currentNumber.isNotEmpty() && currentOperator.isNotEmpty()) {
            val secondNumber = currentNumber.toString().toDouble()
            val result = when (currentOperator) {
                "+" -> currentResult + secondNumber
                "-" -> currentResult - secondNumber
                "X" -> currentResult * secondNumber
                "/" -> currentResult / secondNumber
                else -> 0.0
            }
            currentNumber.clear()
            currentNumber.append(result)
            textViewResult.text = currentNumber.toString()
        }
    }
}