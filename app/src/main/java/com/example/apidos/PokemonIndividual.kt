package com.example.apidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
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
          val individualPoke  = servicioPokemon.getImagen(id)

            individualPoke.enqueue(object : retrofit2.Callback<PokemonImagen>{
                override fun onFailure(call: Call<PokemonImagen>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onResponse(
                    call: Call<PokemonImagen>,
                    response: Response<PokemonImagen>
                ) {


                    val res =  response.body()


                        var front_default = ImageView(this@PokemonIndividual)
                        var back_default = ImageView(this@PokemonIndividual)
                        var front_shiny = ImageView(this@PokemonIndividual)
                        var back_shiny = ImageView(this@PokemonIndividual)

                    if (res != null) {


                        Picasso.get().load(res.sprites.front_default).into(front_default)
                        Picasso.get().load(res.sprites.back_default).into(back_default)
                        Picasso.get().load(res.sprites.front_shiny).into(front_shiny)
                        Picasso.get().load(res.sprites.back_shiny).into(back_shiny)
                    }

                    tvNombrePokemon.text = res?.species?.name

                    Ll_contenedor.addView(front_default)
                    Ll_contenedor.addView(back_default)
                    Ll_contenedor.addView(front_shiny)
                    Ll_contenedor.addView(back_shiny)



                }

            })
        }



    }
}
