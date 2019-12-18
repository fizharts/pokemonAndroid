package com.example.apidos.io

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apidos.PokemonIndividual
import com.example.apidos.R
import com.example.apidos.modelos.ObjetoPokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_pokemon.view.*

// aqui agregamos una variable con un array list
class AdaptadorPorTipo(private val adapatadorPorTipo: ArrayList<PokemonImagen> , private val contexto:Context) : RecyclerView.Adapter<AdaptadorPorTipo.ViewHolder>() {



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

        return adapatadorPorTipo.size


    }



// aqui se mapean los datos con la clase y la vista
    // ejemplo val fotosCompletas = fotos[position]
    // holder.tvCita.text = fotosCompletas.albumId.toString()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    Picasso.get().load(adapatadorPorTipo[position].sprites.front_default).into(holder.uno)




    holder.numero.text = adapatadorPorTipo[position].id.toString()
    holder.texto.text = adapatadorPorTipo[position].species.name
    val id = adapatadorPorTipo[position].id

    var tipoColor:String





        tipoColor = adapatadorPorTipo[position].types[0].type.name


    holder.tipoPruebas.text = tipoColor


    when(tipoColor){


        "fire" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.fire)))
        }



        "water" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.water)))
        }

        "grass" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.grass)))

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
        "normal"->{
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString( R.string.normal)))
        }
        "ghost" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString( R.string.ghost)))
        }
        "ice" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.ice)))
        }
        "dark" -> {
            holder.llFondoTipo.setBackgroundColor(Color.parseColor(contexto.getString(R.string.dark)))
        }


    }





    holder.itemView.setOnClickListener(View.OnClickListener {


        val intend = Intent(contexto, PokemonIndividual::class.java)
        intend.putExtra("id", id.toString())
        contexto.startActivity(intend)


    })

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val uno = itemView.IvUno
        val llFondoTipo = itemView.llFondoTipo
        val texto = itemView.tv_pokemon
        val numero = itemView.tv_numero
        val tipoPruebas = itemView.tipoPruebas



    }

}