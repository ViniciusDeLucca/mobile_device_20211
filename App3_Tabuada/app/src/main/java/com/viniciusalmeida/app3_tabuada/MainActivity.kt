package com.viniciusalmeida.app3_tabuada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var resultadoTabuada: TextView
    lateinit var botaoCalcular: Button
    var numeroTabuada: Int? = null
    var calculo = 0
    var resultado = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadoTabuada = findViewById(R.id.tabuada)
        botaoCalcular = findViewById(R.id.btncalcular)
        botaoCalcular.setOnClickListener{
            numeroTabuada = findViewById<EditText>(R.id.inputNumber).text.toString().toIntOrNull()
            calcularTabuada()
        }
    }
    fun calcularTabuada () {

        numeroTabuada?.let {
            for (i in 1..10){
                calculo = it * i
                resultado+= "$numeroTabuada X $i = $calculo \n"
            }
        }
        resultadoTabuada.text = resultado
    }
}
