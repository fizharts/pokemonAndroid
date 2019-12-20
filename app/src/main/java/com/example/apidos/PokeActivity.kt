package com.example.apidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apidos.io.AdaptadorPokemon
import com.example.apidos.io.PokemonImagen
import com.example.apidos.io.ServicioPokemones
import com.example.apidos.modelos.ObjetoPokemon
import com.example.apidos.modelos.PokemonPorTipo
import kotlinx.android.synthetic.main.activity_poke.*
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



        getTypes()

        verPkemones().also {
            progressBar.visibility = View.GONE
        }




    }

    private fun getTypes() {




        val getPokemonTypes = servicioPokemones.getType()

            getPokemonTypes.enqueue(object :Callback<ObjetoPokemon>{
                override fun onFailure(call: Call<ObjetoPokemon>, t: Throwable) {
                    Toast.makeText(this@PokeActivity,"No funciono", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<ObjetoPokemon>,
                    response: Response<ObjetoPokemon>
                ) {

                    val res = response.body()

                    val listaTipos = ArrayList<String>()

                    if (res != null) {
                       val nombre = res.results

                        listaTipos.add("Tipo")

                        nombre.forEach {
                            listaTipos.add(it.name)
                        }


                        sTipos.adapter = ArrayAdapter<String>(
                            this@PokeActivity,
                            android.R.layout.simple_spinner_dropdown_item,
                            listaTipos
                        )




                    }


                    sTipos.onItemSelectedListener = object : AdapterView.OnItemClickListener,
                        AdapterView.OnItemSelectedListener {




                        override fun onItemClick(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {


                        }

                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        }

                        override fun onItemSelected(
                            p0: AdapterView<*>?,
                            p1: View?,
                            p2: Int,
                            p3: Long
                        ) {

                         var pruebaa  =  p0?.getItemAtPosition(p2).toString()
                            progressBar.visibility = View.VISIBLE

                            arrayPokemones.clear()


                            if (pruebaa!= "Tipo"){
                                Toast.makeText(this@PokeActivity, pruebaa, Toast.LENGTH_SHORT).show()



                                var pokemonesPorTipo = servicioPokemones.getPokemonByType(pruebaa)


                                pokemonesPorTipo.enqueue(object :Callback<PokemonPorTipo>{
                                    override fun onFailure(
                                        call: Call<PokemonPorTipo>,
                                        t: Throwable
                                    ) {
                                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    }

                                    override fun onResponse(
                                        call: Call<PokemonPorTipo>,
                                        response: Response<PokemonPorTipo>
                                    ) {




                                        var res = response.body()

                                        Rv_aqui.removeViewInLayout(View(this@PokeActivity))



                                        if (res != null) {







                                            res.pokemon.forEach {
                                                var id = it.pokemon.url.substring(34, it.pokemon.url.length - 1)



                                                obtenerImagen(id)


                                            }.also {
                                                Toast.makeText(this@PokeActivity,res.pokemon[0].pokemon.name, Toast.LENGTH_SHORT).show()
                                                progressBar.visibility = View.GONE


                                            }



                                        }


                                    }

                                })




                            }



                            }

                    }





                }

            })






    }

    private fun verPkemones() {


        progressBar.visibility = View.VISIBLE

        val verPokes = servicioPokemones.getData()





        verPokes.enqueue(object : Callback<ObjetoPokemon> {
            override fun onFailure(call: Call<ObjetoPokemon>, t: Throwable) {
                Toast.makeText(this@PokeActivity, "No funciono", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ObjetoPokemon>,
                response: Response<ObjetoPokemon>
            ) {



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
                        Rv_aqui.adapter = AdaptadorPokemon(arrayPokemones,this@PokeActivity).also {
                            progressBar.visibility = View.GONE
                        }
                    }









                }
            }

        })


    }





}
