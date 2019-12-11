package com.example.apidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apidos.io.MyAdapter
import com.example.apidos.io.photosService
import com.example.apidos.modelos.Fotos
import kotlinx.android.synthetic.main.activity_mis_citas.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class MisCitas : AppCompatActivity() {


    private val photosService: photosService by lazy {
        com.example.apidos.io.photosService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_citas)


        obtenerFotos()




    }

    private fun obtenerFotos() {

       val todasLasFotos = photosService.getData()


        todasLasFotos.enqueue(object : retrofit2.Callback<ArrayList<Fotos>>{
            override fun onFailure(call: retrofit2.Call<ArrayList<Fotos>>, t: Throwable) {
                Toast.makeText(this@MisCitas,"Fallo", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: retrofit2.Call<ArrayList<Fotos>>,
                response: Response<ArrayList<Fotos>>
            ) {

                    if(response.isSuccessful){
                        Toast.makeText(this@MisCitas,"TodoBien", Toast.LENGTH_SHORT).show()

                        val fotos = ArrayList<Fotos>()


                        var res = response.body()


                        res?.forEach {

                            fotos.add(
                                Fotos(it.albumId,it.id,it.thumbnailUrl,it.title,it.url)
                            )


                        }










                        rvLista.layoutManager = LinearLayoutManager(this@MisCitas)
                        rvLista.adapter = MyAdapter(fotos)






                    }




            }

        })



    }


}
