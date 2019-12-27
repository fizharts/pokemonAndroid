package com.example.apidos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import com.example.apidos.io.Servicios
import com.example.apidos.modelos.HelperPreference
import kotlinx.android.synthetic.main.activity_main.*
import com.example.apidos.modelos.HelperPreference.get
import com.example.apidos.modelos.HelperPreference.set
import com.google.android.material.snackbar.Snackbar
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

     private val Laya by lazy {
         Snackbar.make(makePrueba,"its works",Snackbar.LENGTH_SHORT)
     }


    private val apiService:Servicios by lazy {
        Servicios.create()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val preference = HelperPreference.defaultPrefs(this)


        if (preference["jwt", ""].contains(".")){
            irAlMEnu()



        }




        btnIngresar.setOnClickListener {


            setLogin()


//            creakPreferences()


        }



        tvNuevoUsuario.setOnClickListener{
            val intento = Intent(this, RegisterActivity::class.java)

            startActivity(intento)

            finish()


        }

//        creakPreferences()


    }

    private fun setLogin() {



       val call =  apiService.setUser(
             correo.text.toString(),
             contrasenaDos.text.toString()
             )


        call.enqueue(object : Callback<Token> {
            override fun onFailure(call: retrofit2.Call<Token>, t: Throwable) {
                this@MainActivity.toast(t.localizedMessage)

               Log.d("Error" , t.localizedMessage.toString())


            }

            override fun onResponse(call: retrofit2.Call<Token>, response: Response<Token>) {

                if (response.isSuccessful){
                    var res = response.body()



                    if (res == null){
                        this@MainActivity.toast(getString(R.string.error))
                        return
                    }else{

                        this@MainActivity.toast("todo salio bien creo")
                            this@MainActivity.toast(res.token)

                        creakPreferences(res?.token)

                        irAlMEnu()
                    }



                }



            }

        })


    }


    private fun irAlMEnu() {
        val irMenu = Intent(this, MenuActivity::class.java)

        startActivity(irMenu)
        finish()
    }


    private fun creakPreferences(jwt:String){

        val preference = HelperPreference.defaultPrefs(this)
        preference["jwt"] = jwt

    }


    override fun onBackPressed() {
        if (Laya.isShown){
            super.onBackPressed()
        }else{
            Laya.show()
        }
    }

}

