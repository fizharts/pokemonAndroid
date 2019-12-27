package com.example.apidos.io

import com.example.apidos.Token
import com.example.apidos.modelos.UsuarioConectado
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface Servicios {





            @POST("login2/token")
                fun setUser(@Query("correo")correo:String,@Query("contrasena")contrasena:String):
                    Call<Token>

            @GET("usuarioconectado")
                fun getUsuario(@Header("Authorization") authHeader:String):
                    Call<UsuarioConectado>

                    companion object factory{

                        private const val BASE_URL = "http://129.144.51.42/desarrollos/admUM/public/"

                        fun create(): Servicios{
                            val retrofit = Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()

                            return retrofit.create(Servicios::class.java)
                        }
                    }




}