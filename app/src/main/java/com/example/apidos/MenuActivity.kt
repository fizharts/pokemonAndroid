package com.example.apidos

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.apidos.io.Servicios
import com.example.apidos.modelos.HelperPreference
import com.example.apidos.modelos.HelperPreference.set
import com.example.apidos.modelos.HelperPreference.get
import com.example.apidos.modelos.UsuarioConectado

import kotlinx.android.synthetic.main.activity_menu.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MenuActivity : AppCompatActivity() {


    private val preference by lazy {

        HelperPreference.defaultPrefs(this)

    }

    private val serviceio:Servicios by lazy {
        Servicios.create()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)





 val jwt =   preference["jwt",""]

        Log.d("tokenDos", jwt)

        this.toast(jwt)


        val call = serviceio.getUsuario("Bearer $jwt")
                call.enqueue(object : Callback<UsuarioConectado>{
                    override fun onFailure(call: Call<UsuarioConectado>, t: Throwable) {

                        this@MenuActivity.toast(t.localizedMessage)


                    }

                    override fun onResponse(
                        call: Call<UsuarioConectado>,
                        response: Response<UsuarioConectado>
                    ) {

                       if (response.isSuccessful){
                           val res = response.body()

                            this@MenuActivity.toast("llegamos aqui")

                             val nombre =  res?.relacion?.persona?.primer_nombre

                       }



                    }

                })



//        val preference = HelperPreference.defaultPrefs(this)


        btnRegistrar.setOnClickListener {
             val irRegistro = Intent(this, CrearCita::class.java)

                         startActivity(irRegistro)
        }


        btnCitas.setOnClickListener { 
             val irCitas = Intent(this, MisCitas::class.java)
                        
                         startActivity(irCitas)
        }

        btn_cerrarSecion.setOnClickListener { 
             val irPokeActivity = Intent(this, PokeActivity::class.java)
                        
                         startActivity(irPokeActivity)
        }
    }
}

