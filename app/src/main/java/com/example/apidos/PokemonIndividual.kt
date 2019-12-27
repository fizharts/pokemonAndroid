package com.example.apidos

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apidos.io.Move
import com.example.apidos.io.PokemonImagen
import com.example.apidos.io.ServicioPokemones
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_individual.*
import retrofit2.Call
import retrofit2.Response

class PokemonIndividual : AppCompatActivity() {

    private val servicioPokemon: ServicioPokemones by lazy {
        ServicioPokemones.create()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_individual)


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        val id = getIntent().getExtras()?.getString("id")




        if (id != null) {
            val individualPoke: Call<PokemonImagen> = servicioPokemon.getImagen(id).also { it ->

                it.enqueue(object : retrofit2.Callback<PokemonImagen> {
                    override fun onFailure(call: Call<PokemonImagen>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    @SuppressLint("SetTextI18n", "Range")
                    override fun onResponse(
                        call: Call<PokemonImagen>,
                        response: Response<PokemonImagen>
                    ) {


                        val res = response.body()
                        val tipo = res?.types
                        val ability = res?.stats


                        val speed = ability?.get(0)?.base_stat
                        val specialAtack = ability?.get(1)?.base_stat
                        val defense = ability?.get(2)?.base_stat
                        val attack = ability?.get(3)?.base_stat
                        val hp = ability?.get(4)?.base_stat

                        val typesEachPokemon = res?.types

                        typesEachPokemon?.forEach {
                            var litleTypes = TextView(this@PokemonIndividual)


                            var nombre = it.type.name
                            litleTypes.text = " $nombre /"


                            tvipo.addView(litleTypes)

                        }


                        val movesPokemon = res?.moves

                        val arrayMovesPOkemon = ArrayList<Move>()


                        movesPokemon?.forEach {

//                            val texto = TextView(this@PokemonIndividual)
//
//                            texto.text = it.move.name

//                                    movesAll.addView(texto)

                            arrayMovesPOkemon.add(Move(
                                it.move,
                                it.version_group_details
                            ))



                        }
                            val imagensita = res?.sprites?.back_default.toString()


                        rvMoves.layoutManager = LinearLayoutManager(this@PokemonIndividual)
                        rvMoves.adapter = AdaptadorMoves(arrayMovesPOkemon,this@PokemonIndividual, imagensita , llAtack , cartita , btnCerrar, res?.sprites?.back_default)






                        if (res != null) {
                            Picasso.get().load(res.sprites.front_default).into(ivPokemon)

                        }


                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.morado)))
                        tvTextoPokemon.text = res?.species?.name


                        if (speed != null) {
                            speedCantidad.text = speed.toString()
                            pbSpeed.progress = speed
                            pbSpeed.progressTintList =
                                ColorStateList.valueOf(Color.parseColor(getString(R.string.ghost)))
                        }


                        if (specialAtack != null) {
                            specialDefenseNum.text = specialAtack.toString()
                            pbSpecialDefence.progress = specialAtack
                            pbSpecialDefence.progressTintList =
                                ColorStateList.valueOf(Color.parseColor(getString(R.string.fire)))
                        }


                        if (defense != null) {
                            tvDefense.text = defense.toString()
                            pbdefense.progress = defense
                            pbdefense.progressTintList =
                                ColorStateList.valueOf(Color.parseColor(getString(R.string.grass)))
                        }


                        if (attack != null) {
                            tvattack.text = attack.toString()
                            pbattack.progress = attack
                            pbattack.progressTintList =
                                ColorStateList.valueOf(Color.parseColor(getString(R.string.dark)))
                        }

                        tvHp.text = hp.toString()
                        if (hp != null) {
                            pbHp.progress = hp
                            pbHp.progressTintList =
                                ColorStateList.valueOf(Color.parseColor(getString(R.string.cinco)))
                        }





                        numeroPokemon.text = ("# $id")



                        if (tipo != null) {
                            tipo.forEach {


                                when (it.type.name) {

                                    "fire" -> {

                                        setColor(Color.parseColor(getString(R.string.fire)))

                                    }


                                    "water" -> {

                                        setColor(Color.parseColor(getString(R.string.water)))


                                    }

                                    "grass" -> {
                                        setColor(Color.parseColor(getString(R.string.grass)))

                                    }

                                    "bug" -> {
                                        setColor(Color.parseColor(getString(R.string.bug)))

                                    }

                                    "flying" -> {
                                        setColor(Color.parseColor(getString(R.string.flying)))
                                    }
                                    "ghost" -> {
                                        setColor(Color.parseColor(getString(R.string.ghost)))
                                    }
                                    "ice" -> {
                                        setColor(Color.parseColor(getString(R.string.ice)))
                                    }
                                    "dark" -> {
                                        setColor(Color.parseColor(getString(R.string.dark)))

                                    }
                                    "electric" -> {
                                        setColor(Color.parseColor(getString(R.string.electric)))

                                    }
                                    "fairy" -> {
                                        setColor(Color.parseColor(getString(R.string.fairy)))

                                    }
                                    "fighting" -> {
                                        setColor(Color.parseColor(getString(R.string.fighting)))

                                    }
                                    "rock" -> {
                                        setColor(Color.parseColor(getString(R.string.rock)))

                                    }
                                    "ground" -> {
                                        setColor(Color.parseColor(getString(R.string.ground)))

                                    }
                                    "poison" -> {
                                        setColor(Color.parseColor(getString(R.string.poison)))

                                    }
                                    "steel" -> {
                                        setColor(Color.parseColor(getString(R.string.steel)))

                                    }

                                    "psychic" -> {
                                        setColor(Color.parseColor(getString(R.string.psychic)))

                                    }
                                    "dragon" -> {
                                        setColor(Color.parseColor(getString(R.string.dragon)))

                                    }        "normal" -> {
                                        setColor(Color.parseColor(getString(R.string.normal)))

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

    private fun setColor(color: Int) {


        tvTextoPokemon.setBackgroundColor(color)
        numeroPokemon.setBackgroundColor(color)
        btnStats.setBackgroundColor(color)
        btnStats.setTextColor(Color.parseColor(getString(R.string.blanquito)))

        btnMoves.setOnClickListener {
            llMoves.visibility = View.VISIBLE
            llStats.visibility = View.GONE
            btnMoves.setBackgroundColor(color)
            btnMoves.setTextColor(Color.parseColor(getString(R.string.blanquito)))
            btnStats.setTextColor(Color.parseColor(getString(R.string.negro)))
            btnStats.setBackgroundColor(Color.parseColor(getString(R.string.fondNeutro)))

        }

        btnStats.setOnClickListener {
            llMoves.visibility = View.GONE
            llStats.visibility = View.VISIBLE
            btnStats.setBackgroundColor(color)
            btnMoves.setBackgroundColor(Color.parseColor(getString(R.string.fondNeutro)))
            btnStats.setTextColor(Color.parseColor(getString(R.string.blanquito)))
            btnMoves.setTextColor(Color.parseColor(getString(R.string.negro)))
        }

    }


}
