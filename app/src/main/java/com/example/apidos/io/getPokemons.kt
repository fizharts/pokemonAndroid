package com.example.apidos.io

import com.example.apidos.modelos.ObjetoPokemon
import com.example.apidos.modelos.Pokemons

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GetPokemons {


            @GET("pokemon")
                        abstract fun getData(): Call<ArrayList<Pokemons>>




            @GET("pokemon/{id}")
                        abstract fun getImagen(@Path ("id")pokemonId:String): Call<PokemonImagen>


                companion object Factory{

                     const val BASE_URL = "https://pokeapi.co/api/v2/"

                    fun create(): GetPokemons{
                        val retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                        return retrofit.create(GetPokemons::class.java)
                    }
                }


}