package com.viniciusalmeida.app7_listausuariofoto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsuarioAdapter(private var listaUsuario: MutableList<Usuario>):RecyclerView.Adapter<UsuarioAdapter.ItemViewHolder>() {
//
    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtGraduacao: TextView = view.findViewById(R.id.txtGraduacao)
        val txtSetor: TextView = view.findViewById(R.id.txtSetor)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaUsuario[position].foto?.let{
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtNome.text = listaUsuario[position].nome
        holder.txtGraduacao.text = listaUsuario[position].graduacao.nome
        holder.txtSetor.text = listaUsuario[position].setor.nome

    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaUsuario.size
    }
}
