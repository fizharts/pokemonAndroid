package com.example.apidos.io

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

            @GET("posts")
                        abstract fun getData(): Call<ArrayList<Datos>>


            
            
                companion object Factory{
            
                    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
            
                    fun create(): ApiService{
                        val retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
            
                        return retrofit.create(ApiService::class.java)
                    }
                }

}