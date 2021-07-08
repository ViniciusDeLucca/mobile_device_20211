package com.viniciusalmeida.app11_tarefafoto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var tarefaAdapter: TarefaAdapter
    lateinit var btnIncluir: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.titulo_lista)

        val rv = findViewById<RecyclerView>(R.id.rvTarefa)
        tarefaAdapter = TarefaAdapter(lista)
        btnIncluir = findViewById(R.id.btnIncluir)

        rv.adapter = tarefaAdapter

        btnIncluir.setOnClickListener(){
            val intent = Intent(this, CadastroAct::class.java)
            startActivity(intent)
        }
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
    // Lista static
    companion object{
        val lista = mutableListOf<Tarefa>()
    }
    override fun onResume() {
        super.onResume()
        tarefaAdapter.notifyDataSetChanged()
    }
}