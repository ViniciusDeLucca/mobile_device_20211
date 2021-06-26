package com.viniciusalmeida.app6_shortbio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var botaoSobre : Button
    private lateinit var botaoFormacao : Button
    private lateinit var botaoExperiencia : Button
    private lateinit var botaoObjetivo : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoSobre = findViewById(R.id.btnSobre)
        botaoFormacao = findViewById(R.id.btnFormacao)
        botaoExperiencia = findViewById(R.id.btnExperiencia)
        botaoObjetivo = findViewById(R.id.btnObjetivo)

        botaoSobre.setOnClickListener {
            val intentSobre = Intent(this@MainActivity, SobreAct::class.java)
            startActivity(intentSobre)
        }
        botaoFormacao.setOnClickListener {
            val intentFormacao = Intent(this@MainActivity, FormacaoAct::class.java)
            startActivity(intentFormacao)
        }
        botaoExperiencia.setOnClickListener {
            val intentExperiencia = Intent(this@MainActivity, ExperienciaAct::class.java)
            startActivity(intentExperiencia)
        }
        botaoObjetivo.setOnClickListener {
            val intentObjetivo = Intent(this@MainActivity, ObjetivoAct::class.java)
            startActivity(intentObjetivo)
        }
    }
}