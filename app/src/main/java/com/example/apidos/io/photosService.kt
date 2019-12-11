package com.example.apidos.io

import com.example.apidos.modelos.Fotos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface photosService {
    
    
            @GET("photos")
                        abstract fun getData(): Call<ArrayList<Fotos>>
            
            
                companion object factory{
            
                    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
            
                    fun create(): photosService{
                        val retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
            
                        return retrofit.create(photosService::class.java)
                    }
                }
}