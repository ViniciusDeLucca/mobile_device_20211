package com.viniciusalmeida.app2_sorteionumero

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var gerarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gerarButton = findViewById(R.id.btngerar)
            gerarButton.setOnClickListener{
                gerarNumero()
            }

    }


    @SuppressLint("SetTextI18n")
    fun gerarNumero() {
        texto = findViewById(R.id.txtnumeros)
        val numeroGerado = Random().nextInt(11)
        texto.text = "O número gerado é: $numeroGerado."
    }
}