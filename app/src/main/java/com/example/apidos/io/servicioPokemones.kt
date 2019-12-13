package com.example.apidos.io

import com.example.apidos.modelos.ObjetoPokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ServicioPokemones {



                @GET("pokemon/?offset=0&limit=50")
                            abstract fun getData(): Call<ObjetoPokemon>

                @GET("pokemon/{id}")
                abstract fun getImagen(@Path("id")pokemonId:String): Call<PokemonImagen>


                
                
                    companion object factory{
                
                        private const val BASE_URL = "https://pokeapi.co/api/v2/"
                
                        fun create(): ServicioPokemones{
                            val retrofit = Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                
                            return retrofit.create(ServicioPokemones::class.java)
                        }
                    }
                    




}