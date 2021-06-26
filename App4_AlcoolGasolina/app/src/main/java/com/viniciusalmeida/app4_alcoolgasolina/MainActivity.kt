package com.viniciusalmeida.app4_alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var resultado: TextView
    lateinit var botaoCalcular: Button
    private var litroGas: Double? = null
    private var litroAlc: Double? = null
    private var total: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultado = findViewById(R.id.strResultado)
        botaoCalcular = findViewById(R.id.btnCalcular)
        botaoCalcular.setOnClickListener {
            litroAlc = findViewById<EditText>(R.id.inputAlcool).text.toString().toDoubleOrNull()
            litroGas = findViewById<EditText>(R.id.inputGasolina).text.toString().toDoubleOrNull()
            calcularPreco()
        }
    }

    fun calcularPreco() {

        var final = ""
        total = litroGas?.let { litroAlc?.div(it) }
        if (total!! < 0.7) {
            final ="Álcool é a melhor opção!"
        } else if (total!! > 0.7) {
            final ="Gasolina é a melhor opção!"
        } else {
            final ="Ambas são iguais!"
        }
        resultado.text = final
    }
}