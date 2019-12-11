package com.example.apidos.io

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ObtenerUsuarios {
    
    
    
                @GET("users")
                            abstract fun getUsuarios(): Call<ArrayList<Usuarios>>
                
                
                    companion object Factory{
                
                        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
                
                        fun create(): ObtenerUsuarios{
                            val retrofit = Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                
                            return retrofit.create(ObtenerUsuarios::class.java)
                        }
                    }
    
    
    
    
}