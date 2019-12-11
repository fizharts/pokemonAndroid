package com.example.apidos

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import com.example.apidos.io.ApiService
import com.example.apidos.io.Datos
import com.example.apidos.io.ObtenerUsuarios
import com.example.apidos.io.Usuarios
import kotlinx.android.synthetic.main.activity_crear_cita.*
import retrofit2.Call
import java.util.*
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.ArrayList

@Suppress("PLUGIN_WARNING")
class CrearCita : AppCompatActivity() {



    private val obtenerUsuarios: ObtenerUsuarios by lazy {
        ObtenerUsuarios.create()
    }





    private val apiService:ApiService by lazy {
            ApiService.create()
     }





    private val calendar = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cita)
//        var spinnerOptions = findViewById<Spinner>(R.id.spinnerOptions)
//        var btnSiguiente = findViewById<Button>(R.id.btnSiguiente)

        
        pruebaSpinner()
    
        cargarApi()


        this.btnSiguiente.setOnClickListener {

            Toast.makeText(this,"Listo", Toast.LENGTH_SHORT).show()

            this.cvPasoUno.visibility = View.GONE
            this.cvPasoDos.visibility = View.VISIBLE



        }

        this.btnCrear.setOnClickListener {
            Toast.makeText(this,"Cread", Toast.LENGTH_SHORT).show()

            finish()


        }


        this.etFecha.setOnClickListener{



            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMouth = calendar.get(Calendar.DAY_OF_MONTH)

            val listener = DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
                Toast.makeText(this,"$y - $m - $d", Toast.LENGTH_SHORT).show()
                calendar.set(y,m,d)
                this.etFecha.setText("$y - $m - $d")

                this.verRadioButtons()


            }

            DatePickerDialog(
                this,
                listener,
                year,
                month,
                dayOfMouth
            ).show()


        }


    }

    private fun pruebaSpinner() {


       val callUsuarios = obtenerUsuarios.getUsuarios()

        callUsuarios.enqueue(object : Callback <ArrayList<Usuarios>>{
            override fun onFailure(call: Call<ArrayList<Usuarios>>, t: Throwable) {
                Toast.makeText(this@CrearCita,"Error", Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(
                call: Call<ArrayList<Usuarios>>,
                response: Response<ArrayList<Usuarios>>
            ) {

                if (response.isSuccessful){

                    val res = response.body()
                    val arrayUsuarios = ArrayList<String>()

                    res?.forEach {
                        val textito = TextView(this@CrearCita)
                            textito.id = View.generateViewId()
                            textito.text = it.phone

                        val TextitoDos = TextView(this@CrearCita)
                            TextitoDos.id = View.generateViewId()
                            TextitoDos.text = it.email


                        aqui.addView(textito)
                        aqui.addView(TextitoDos)


                        arrayUsuarios.add(it.email)
                    }




                    sPrueba.adapter = ArrayAdapter<String>(
                                        this@CrearCita,
                                        android.R.layout.simple_spinner_dropdown_item,
                                        arrayUsuarios

                                    )



                }
            }


        })




    }


    private fun cargarApi() {


  val call =  apiService.getData()

        call.enqueue(object: Callback<ArrayList<Datos>>{
            override fun onFailure(call: Call<ArrayList<Datos>>, t: Throwable) {

                Toast.makeText(this@CrearCita,"Error", Toast.LENGTH_SHORT).show()
                finish()
            }


            override fun onResponse(
                call: Call<ArrayList<Datos>>,
                response: Response<ArrayList<Datos>>
            ) {

                if (response.isSuccessful){

                   val datosRest = response.body()
                    val opciones = ArrayList<String>()


                    datosRest?.forEach {
                        opciones.add(it.title)
                    }



                    spinnerOptions .adapter = ArrayAdapter<String>(
                        this@CrearCita,
                        android.R.layout.simple_spinner_dropdown_item,
                        opciones
                    )
                }


            }


        })










    }

    private fun verRadioButtons() {

        rGrup.clearCheck()
        rGrup.removeAllViews()

        val horas = arrayOf(
            "3:00 PM",
            "3:30 PM",
            "4:00 PM",
            "4:30 PM",
            "5:00 PM"
        )

        horas.forEach {
            val radioButton = RadioButton(this)
            radioButton.id = View.generateViewId()
            radioButton.text = it
            rGrup.addView(radioButton)
        }







    }
}


