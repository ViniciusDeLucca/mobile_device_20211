package com.viniciusalmeida.app9_tarefakeep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(private var listaTarefa: MutableList<Tarefa>): RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtTarefa: TextView = view.findViewById(R.id.txtTarefa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.item_tarefa, parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtTarefa.text = listaTarefa[position].tarefa
    }
    override fun getItemCount(): Int {
        return listaTarefa.size
    }

}