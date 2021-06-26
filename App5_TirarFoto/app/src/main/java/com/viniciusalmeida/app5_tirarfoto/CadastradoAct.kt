package com.viniciusalmeida.app5_tirarfoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class CadastradoAct : AppCompatActivity() {
    lateinit var textgrid: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrado)

        textgrid = findViewById(R.id.txtGrid)

        val usuario = intent.extras?.get("USUARIO") as Usuario

        listaUsuario.add(usuario)

        textgrid.text = listaUsuario.toString()

        Toast.makeText(this, usuario.nome, Toast.LENGTH_LONG).show()
    }

    companion object{
        val listaUsuario = mutableListOf<Usuario>()
    }
}