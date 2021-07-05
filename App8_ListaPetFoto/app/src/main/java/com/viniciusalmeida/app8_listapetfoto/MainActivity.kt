@file:Suppress("DEPRECATION")

package com.viniciusalmeida.app8_listapetfoto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvPet)
        val lista = mutableListOf(
            Pet(nome = "Catatau", raca = Raca.CACHORRO, foto = resources.getDrawable(R.drawable.catatau)),
            Pet(nome = "Mia", raca = Raca.GATO, foto = resources.getDrawable(R.drawable.mia)),
            Pet(nome = "Joana", raca = Raca.PASSARINHO, foto = resources.getDrawable(R.drawable.joana))
        )
        rv.adapter = PetAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)
    }
}