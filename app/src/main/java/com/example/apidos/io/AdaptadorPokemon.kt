package com.example.apidos.io

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.apidos.PokemonIndividual
import com.example.apidos.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon.view.*


// aqui agregamos una variable con un array list
    class AdaptadorPokemon(private val adaptadorPokemon: ArrayList<PokemonImagen> , private val contexto:Context ) : RecyclerView.Adapter<AdaptadorPokemon.ViewHolder>() {
    


        // crear la vista
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    
            return ViewHolder(
                LayoutInflater.from(
                    parent.context)
                    .inflate(
                        R.layout.item_pokemon,
                        parent,
                        false)
            )
    
    
        }


    
        // devuelve la cantidad de elementos
        override fun getItemCount(): Int {
    
            return adaptadorPokemon.size
    
    
        }

    
    
    // aqui se mapean los datos con la clase y la vista
        // ejemplo val fotosCompletas = fotos[position]
        // holder.tvCita.text = fotosCompletas.albumId.toString()
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

                Picasso.get().load(adaptadorPokemon[position].sprites.front_default).into(holder.uno)
                Picasso.get().load(adaptadorPokemon[position].sprites.back_default).into((holder.dos))
                Picasso.get().load(adaptadorPokemon[position].sprites.front_shiny).into(holder.tres)
                Picasso.get().load(adaptadorPokemon[position].sprites.back_shiny).into(holder.cuatro)
                holder.numero.text = adaptadorPokemon[position].id.toString()
                holder.texto.text = adaptadorPokemon[position].species.name
                val id = adaptadorPokemon[position].id
            
        
        holder.itemView.setOnClickListener(View.OnClickListener { 
            Toast.makeText(contexto,id.toString(), Toast.LENGTH_SHORT).show()

             val intend = Intent(contexto, PokemonIndividual::class.java)
                        intend.putExtra("id",id.toString())
                          contexto.startActivity(intend)


        })
    

        }
    
        // aqui  recuperamos los elementos del Xml
        // ejemplo  val tvCita = itemView.tvCita
    
        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            val uno = itemView.IvUno
            val dos = itemView.IvDos
            val tres = itemView.IvTres
            val cuatro = itemView.IvCuatro
            val texto = itemView.tv_pokemon
            val numero = itemView.tv_numero
    

    
    
        }


    
    }