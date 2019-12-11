package com.example.apidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apidos.modelos.HelperPreference
import kotlinx.android.synthetic.main.activity_main.*
import com.example.apidos.modelos.HelperPreference.get

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btnIngresar = findViewById<Button>(R.id.btnIngresar)
//        val tvNuevoUsuario = findViewById<TextView>(R.id.tvNuevoUsuario)

//
//        val preferences =  getSharedPreferences("general", Context.MODE_PRIVATE)
//
//        val session    =    preferences.getBoolean("sesion", false)
//

        val preference = HelperPreference.defaultPrefs(this)


        if (preference["session", false]){
            irAlMEnu()
        }




        btnIngresar.setOnClickListener {



                   irAlMEnu()

        }



        tvNuevoUsuario.setOnClickListener{
            val intento = Intent(this, RegisterActivity::class.java)

            startActivity(intento)

            finish()


        }


    }

    private fun irAlMEnu() {
        val irMenu = Intent(this, MenuActivity::class.java)

        startActivity(irMenu)
        finish()
    }


    public fun crearPreferencias(){

        val preference = HelperPreference.defaultPrefs(this)
        preference["session",false]

    }

}

