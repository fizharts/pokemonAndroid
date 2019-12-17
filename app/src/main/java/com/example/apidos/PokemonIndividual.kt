package com.example.apidos

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.setPadding
import com.example.apidos.io.PokemonImagen
import com.example.apidos.io.ServicioPokemones
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_poke.*
import kotlinx.android.synthetic.main.activity_pokemon_individual.*
import kotlinx.android.synthetic.main.activity_pokemon_individual.view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class PokemonIndividual : AppCompatActivity() {

    private val servicioPokemon:ServicioPokemones by lazy {
        ServicioPokemones.create()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_individual)


        val id = getIntent().getExtras()?.getString("id")







        if (id != null) {
            val individualPoke: Call<PokemonImagen> = servicioPokemon.getImagen(id).also { it ->

                it.enqueue(object : retrofit2.Callback<PokemonImagen>{
                    override fun onFailure(call: Call<PokemonImagen>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    @SuppressLint("SetTextI18n")
                    override fun onResponse(
                        call: Call<PokemonImagen>,
                        response: Response<PokemonImagen>
                    ) {


                        val res =  response.body()
                        val tipo = res?.types
                        val ability = res?.stats

                        val speed =  ability?.get(0)?.base_stat
                        val specialAtack = ability?.get(1)?.base_stat
                        val defense = ability?.get(2)?.base_stat
                        val attack = ability?.get(3)?.base_stat

                        val typesEachPokemon = res?.types

                            typesEachPokemon?.forEach {
                                var litleTypes = TextView(this@PokemonIndividual)


                                var nombre = it.type.name
                                litleTypes.text =  " $nombre /"


                                tvipo.addView(litleTypes)

                            }



                        if (res != null) {
                            Picasso.get().load(res.sprites.front_default).into(ivPokemon)

                        }


                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.morado)))
                        tvTextoPokemon.text = res?.species?.name


                        if (speed != null) {
                            speedCantidad.text = speed.toString()
                            pbSpeed.progress = speed
                            pbSpeed.progressTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.uno)))
                        }


                        if (specialAtack != null) {
                            specialDefenseNum.text = specialAtack.toString()
                            pbSpecialDefence.progress = specialAtack
                            pbSpecialDefence.progressTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.dos)))
                        }


                        if (defense != null){
                            tvDefense.text = defense.toString()
                            pbdefense.progress = defense
                            pbdefense.progressTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.tres)))
                        }


                        if (attack != null){
                            tvattack.text = attack.toString()
                            pbattack.progress = attack
                            pbattack.progressTintList = ColorStateList.valueOf(Color.parseColor(getString(R.string.cuatro)))
                        }






                        numeroPokemon.text = ("# $id")

                        if (tipo != null) {
                            tipo.forEach {


                                when(it.type.name){

                                    "fire" -> {
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.Rojo)))
                                        numeroPokemon.setBackgroundColor(Color.parseColor(getString(R.string.Rojo)))
                                    }



                                    "water" -> {
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.azul)))
                                        numeroPokemon.setBackgroundColor(Color.parseColor(getString(R.string.azul)))
                                    }

                                    "grass" -> {
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.verde)))
                                        numeroPokemon.setBackgroundColor(Color.parseColor(getString(R.string.verde)))
                                    }

                                    "bug"-> {
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.bug)))
                                        numeroPokemon.setBackgroundColor(Color.parseColor(getString(R.string.bug)))

                                    }

                                    "flying" -> {
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.flying)))
                                        numeroPokemon.setBackgroundColor(Color.parseColor(getString(R.string.flying)))

                                    }



                                }

//                                tvTipo.text = it.type.name

                            }
                        }



                    }

                })
            }
        }



    }
}
