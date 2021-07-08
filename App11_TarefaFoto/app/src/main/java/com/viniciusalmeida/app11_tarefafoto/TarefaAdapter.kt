package com.viniciusalmeida.app11_tarefafoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(var listaTarefa: MutableList<Tarefa>):RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_tarefa) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtTarefa: TextView = view.findViewById(R.id.txtTarefa)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_tarefa) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaTarefa[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtTarefa.text = listaTarefa[position].tarefa
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaTarefa.size
    }
}