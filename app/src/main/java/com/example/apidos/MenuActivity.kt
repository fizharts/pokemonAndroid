package com.example.apidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


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
