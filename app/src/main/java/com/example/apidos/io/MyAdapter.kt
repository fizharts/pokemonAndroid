package com.example.apidos.io

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.apidos.R
import com.example.apidos.modelos.Fotos
import kotlinx.android.synthetic.main.item_recycler.view.*


// aqui agregamos una variable con un array list
class MyAdapter(private val fotos: ArrayList<Fotos>) :RecyclerView.Adapter<MyAdapter.ViewHolder>() {



    // crear la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(
                parent.context)
                .inflate(
                    R.layout.item_recycler,
                    parent,
                    false)
        )


    }

    // devuelve la cantidad de elementos
    override fun getItemCount(): Int {

        return fotos.size


    }



// aqui se mapean los datos con la clase y la vista
    // ejemplo val fotosCompletas = fotos[position]
    // holder.tvCita.text = fotosCompletas.albumId.toString()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val fotosCompletas = fotos[position]

            holder.tvCita.text = fotosCompletas.albumId.toString()
            holder.tvEncabezado.text = fotosCompletas.id.toString()
            holder.tvFecha.text = fotosCompletas.title
            holder.tvOtros.text = fotosCompletas.url

    }

    // aqui  recuperamos los elementos del Xml
    // ejemplo  val tvCita = itemView.tvCita

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){


        val tvCita = itemView.tvCita
        val tvEncabezado = itemView.tvEncabezado
        val tvFecha = itemView.tvFecha
        val tvOtros = itemView.tvOtros


    }

}