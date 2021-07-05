@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app7_listausuariofoto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf(
            Usuario(nome="Michael", email="mj@gmail.com", graduacao= Graduacao.GRADUADO, setor= Setor.DESENVOLVEDOR, foto=resources.getDrawable(R.drawable.mj)),
            Usuario(nome="Pelé", email="pele@gmail.com", graduacao= Graduacao.CURSANDO, setor= Setor.ANALISTA, foto = resources.getDrawable(R.drawable.pele)),
            Usuario(nome="Bill Gates", email="pele@gmail.com", graduacao = Graduacao.POSGRADUADO, setor = Setor.TESTER, foto = resources.getDrawable(R.drawable.billgates))
        )
        rv.adapter = UsuarioAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)
    }
}
