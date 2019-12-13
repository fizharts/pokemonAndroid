package com.example.apidos

import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.GetChars
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apidos.io.AdaptadorPokemon
import com.example.apidos.io.GetPokemons
import com.example.apidos.io.PokemonImagen
import com.example.apidos.io.ServicioPokemones
import com.example.apidos.modelos.ObjetoPokemon
import com.example.apidos.modelos.Pokemons
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_poke.*
import kotlinx.android.synthetic.main.progress_bar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokeActivity : AppCompatActivity() {


    private val servicioPokemones: ServicioPokemones by lazy {
        ServicioPokemones.create()
    }

    private  var arrayPokemones = ArrayList<PokemonImagen>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke)

        var progressBar = ProgressBar(
            this,
            null,
            android.R.attr.progressBarStyle
        )

        progressBar.visibility = View.VISIBLE



        verPkemones()



    }

    private fun verPkemones() {




        val verPokes = servicioPokemones.getData()





        verPokes.enqueue(object : Callback<ObjetoPokemon> {
            override fun onFailure(call: Call<ObjetoPokemon>, t: Throwable) {
                Toast.makeText(this@PokeActivity, "No funciono", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ObjetoPokemon>,
                response: Response<ObjetoPokemon>
            ) {

                Toast.makeText(this@PokeActivity, "AQui", Toast.LENGTH_SHORT).show()

                var pruebita = response.body()?.results

                pruebita?.forEach {


                    val id = it.url.substring(34, it.url.length - 1)


                    obtenerImagen(id)


                }







            }

        })


    }

    private fun obtenerImagen(id: String) {

        val obtenerImagenes = servicioPokemones.getImagen(id)

        obtenerImagenes.enqueue(object : Callback<PokemonImagen> {
            override fun onFailure(call: Call<PokemonImagen>, t: Throwable) {
                Toast.makeText(this@PokeActivity, "Problemas al cargar datos", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(
                call: Call<PokemonImagen>,
                response: Response<PokemonImagen>
            ) {
                if (response.isSuccessful) {

                    val res = response.body()




                    if (res != null) {
                        arrayPokemones.add(res)

                        Rv_aqui.layoutManager = GridLayoutManager(this@PokeActivity,2)
                        Rv_aqui.adapter = AdaptadorPokemon(arrayPokemones,this@PokeActivity)
                    }









                }
            }

        })


    }


}
