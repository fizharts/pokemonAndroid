package com.example.apidos

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.apidos.io.Move
import com.example.apidos.io.MoveTypes
import com.example.apidos.io.ServicioPokemones
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_individual.view.*
import kotlinx.android.synthetic.main.item_moves.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_pokemon_individual.view.textAtaque as textAtaque1

// aqui agregamos una variable con un array list
class AdaptadorMoves(
    private val adaptadorMoves: ArrayList<Move>,
    private val contexto: Context,
    private val id: String,
    private val llAtack: LinearLayout,
    private val cartita: LinearLayout,
    private val btnCerrar: Button,
    private var backDefault: String?
) : RecyclerView.Adapter<AdaptadorMoves.ViewHolder>() {

    private val servicioPokemones: ServicioPokemones by lazy {
        ServicioPokemones.create()
    }



    // crear la vista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(
                parent.context
            )
                .inflate(
                    R.layout.item_moves,
                    parent,
                    false
                )
        )


    }


    override fun getItemCount(): Int {

        return adaptadorMoves.size


    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ataque = adaptadorMoves[position].move.name


//            holder.itemMove.text = adaptadorMoves[position].move.name
        holder.itemMove.text = adaptadorMoves[position].move.name

        val obtenerTipos = servicioPokemones.getMoveType(ataque)

        obtenerTipos.enqueue(object : Callback<MoveTypes> {
            override fun onFailure(call: Call<MoveTypes>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MoveTypes>, response: Response<MoveTypes>) {
                if (response.isSuccessful) {
                    val res = response.body()
                    val ataque = res?.accuracy

                    llAtack.descritionAtack.text = ""
                    holder.itemType.text = ataque.toString()


                    holder.itemAtack.text = res?.type?.name

                    val tipoMov = res?.type?.name

                    Picasso.get().load(backDefault).into(llAtack.imageBAck)

                   val efectAtack = res?.effect_entries?.get(0)?.effect
//                    val remplazo = efectAtack?.replace("effect_chance", res?.effect_chance.toString())

                    llAtack.descritionAtack.text = efectAtack

                    when (tipoMov) {


                        "fire" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.fire
                                    )
                                )

                            )




                        }


                        "water" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.water
                                    )
                                )
                            )



                        }

                        "grass" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.grass
                                    )
                                )
                            )



                        }

                        "bug" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.bug
                                    )
                                )
                            )


                        }

                        "flying" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.flying
                                    )
                                )
                            )

                        }

                        "poison" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.morado
                                    )
                                )
                            )



                        }
                        "normal" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.normal
                                    )
                                )
                            )

                        }
                        "ghost" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.ghost
                                    )
                                )
                            )

                        }
                        "dark" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.dark
                                    )
                                )
                            )

                        }
                        "electric" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.electric
                                    )
                                )
                            )

                        }
                        "fairy" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.fairy
                                    )
                                )
                            )



                        }
                        "fighting" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.fighting
                                    )
                                )
                            )

                        }
                        "rock" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.rock
                                    )
                                )
                            )

                        }
                        "ground" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.ground
                                    )
                                )
                            )

                        }
                        "poison" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.poison
                                    )
                                )
                            )
                            btnCerrar.ponerColor("poison",contexto)

                        }
                        "psychic" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.psychic
                                    )
                                )
                            )

                        }
                        "steel" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.steel
                                    )
                                )
                            )

                        }
                        "dragon" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.dragon
                                    )
                                )
                            )

                        }
                        "ice" -> {
                            holder.itemAtack.setBackgroundColor(
                                Color.parseColor(
                                    contexto.getString(
                                        R.string.ice
                                    )
                                )
                            )
                        }


                    }


                }
            }

        })


        holder.itemView.setOnClickListener {

            llAtack.visibility = View.VISIBLE
            cartita.visibility = View.GONE
            llAtack.textAtaque1.text = ataque








            btnCerrar.ponerColor(holder.itemAtack.text.toString() ,contexto)




        }


        btnCerrar.setOnClickListener {
            llAtack.visibility = View.GONE


            cartita.visibility = View.VISIBLE
        }

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemMove = itemView.itemMove

        val itemType = itemView.itemType

        val itemAtack = itemView.itemAtack


        val llAtack = itemView.llAtack

        val tvTextoPokemon = itemView.tvTextoPokemon


    }

}