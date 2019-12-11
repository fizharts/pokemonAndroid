package com.example.apidos.io

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ObtenerImagen {




            @GET("1")
                        abstract fun getData( ): Call<PokemonImagen>


    companion object factory{

                    private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/"

                    fun create(): ObtenerImagen{
                        val retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()

                        return retrofit.create(ObtenerImagen::class.java)
                    }
                }




}