package com.example.apidos

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.setPadding
import com.example.apidos.io.PokemonImagen
import com.example.apidos.io.ServicioPokemones
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_individual.*
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


//

                        if (res != null) {
                            Picasso.get().load(res.sprites.front_default).into(ivPokemon)
                            Picasso.get().load(res.sprites.back_default).into(ivPokemonBack)
                        }


                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.morado)))
                        tvTextoPokemon.text = res?.species?.name



                        if (tipo != null) {
                            tipo.forEach {


                                when(it.type.name){

                                    "fire" -> {
                                        TipoPokemons.setBackgroundColor(Color.parseColor(getString(
                                            R.string.Rojo)))
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.Rojo)))
                                        TipoPokemons.text = "Fire"
                                    }



                                    "water" -> {
                                        TipoPokemons.setBackgroundColor(Color.parseColor(getString(
                                            R.string.azul)))
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.azul)))
                                        TipoPokemons.text = "Water"
                                    }

                                    "grass" -> {
                                        TipoPokemons.setBackgroundColor(Color.parseColor(getString(
                                            R.string.verde)))
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.verde)))
                                        TipoPokemons.text = "Grass"
                                    }

                                    "bug"-> {
                                        TipoPokemons.setBackgroundColor(Color.parseColor(getString(
                                            R.string.bug)))
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.bug)))
                                        TipoPokemons.text = "bug"

                                    }

                                    "flying" -> {
                                        TipoPokemons.setBackgroundColor(Color.parseColor(getString(
                                            R.string.flying)))
                                        tvTextoPokemon.setBackgroundColor(Color.parseColor(getString(R.string.flying)))
                                        TipoPokemons.text = "flying"
                                    }



                                }

                                tvTipo.text = it.type.name

                            }
                        }



                    }

                })
            }
        }



    }
}
