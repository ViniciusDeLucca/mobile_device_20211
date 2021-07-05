package com.viniciusalmeida.app8_listapetfoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(private var listaPet: MutableList<Pet>): RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgView: ImageView = view.findViewById(R.id.imgView)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtPet: TextView = view.findViewById(R.id.txtPet)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.item_pet, parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaPet[position].foto?.let {
            holder.imgView.setImageDrawable(it)
        }
        holder.txtNome.text = listaPet[position].nome
        holder.txtPet.text = listaPet[position].raca.nome
    }
    override fun getItemCount(): Int {
        return listaPet.size
    }

}