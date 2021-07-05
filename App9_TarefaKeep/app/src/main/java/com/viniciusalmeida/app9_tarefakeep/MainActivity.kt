@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app9_tarefakeep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvTarefa)
        val lista = mutableListOf(
            Tarefa(tarefa = "Lavar o carro."),
            Tarefa(tarefa = "Preciso ir ao dentista e em seguida ir no banco pagar algumas contas."),
            Tarefa(tarefa = "Visitar meus primos quando eles chegarem de viagem."),
            Tarefa(tarefa = "Entregar as tarefas para o professor, para receber a nota.")
        )
        rv.adapter = TarefaAdapter(lista)
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}