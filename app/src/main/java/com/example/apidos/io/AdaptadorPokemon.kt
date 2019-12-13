package com.example.apidos.io

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.provider.Settings.Global.getString
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
class AdaptadorPokemon(
    private val adaptadorPokemon: ArrayList<PokemonImagen>,
    private val contexto: Context
) : RecyclerView.Adapter<AdaptadorPokemon.ViewHolder>() {


    // crear la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(
                parent.context
            )
                .inflate(
                    R.layout.item_pokemon,
                    parent,
                    false
                )
        )


    }



    override fun getItemCount(): Int {

        return adaptadorPokemon.size


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Picasso.get().load(adaptadorPokemon[position].sprites.front_default).into(holder.uno)

        holder.numero.text = adaptadorPokemon[position].id.toString()
        holder.texto.text = adaptadorPokemon[position].species.name
        val id = adaptadorPokemon[position].id
        val tipoColor = adaptadorPokemon[position].types[0].type.name
        holder.tipoPruebas.text = tipoColor


            when(tipoColor){


                "fire" -> {
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.Rojo)))
                }



                "water" -> {
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.azul)))
                }

                "grass" -> {
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.verde)))

                }

                "bug"-> {
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.bug)))

                }

                "flying" -> {
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.flying)))

                }

                "poison"->{
                    holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.morado)))

                }

            }





        holder.itemView.setOnClickListener(View.OnClickListener {


            val intend = Intent(contexto, PokemonIndividual::class.java)
            intend.putExtra("id", id.toString())
            contexto.startActivity(intend)


        })


    }




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val uno = itemView.IvUno
        val llFondoTipo = itemView.llFondoTipo
        val texto = itemView.tv_pokemon
        val numero = itemView.tv_numero
        val tipoPruebas = itemView.tipoPruebas


    }


}