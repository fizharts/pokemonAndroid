package com.example.apidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apidos.modelos.HelperPreference
import kotlinx.android.synthetic.main.activity_main.*
import com.example.apidos.modelos.HelperPreference.get
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

     private val Laya by lazy {
         Snackbar.make(makePrueba,"its works",Snackbar.LENGTH_SHORT)
     }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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

        creakPreferences()


    }



    private fun irAlMEnu() {
        val irMenu = Intent(this, MenuActivity::class.java)

        startActivity(irMenu)
        finish()
    }


    private fun creakPreferences(){

        val preference = HelperPreference.defaultPrefs(this)
        preference["session",false]

    }


    override fun onBackPressed() {
        if (Laya.isShown){
            super.onBackPressed()
        }else{
            Laya.show()
        }
    }
}

