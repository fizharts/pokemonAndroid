package com.example.apidos

import android.content.Context
import android.graphics.Color
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


fun Int.multiplicar(numero:Int):Int{
    return this * numero
}



fun Context.toast(message: CharSequence){
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}




fun RecyclerView.ViewHolder.ponerFondo(color:Int) {

    this.itemView.setBackgroundColor(color)
}


fun Button.ponerColor(color: String, contexto:Context){

    when (color) {


        "fire" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.fire
                    )
                )

            )



        }


        "water" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.water
                    )
                )
            )
        }

        "grass" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.grass
                    )
                )
            )

        }

        "bug" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.bug
                    )
                )
            )

        }

        "flying" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.flying
                    )
                )
            )

        }

        "poison" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.morado
                    )
                )
            )

        }
        "normal" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.normal
                    )
                )
            )
        }
        "ghost" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.ghost
                    )
                )
            )
        }
        "dark" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.dark
                    )
                )
            )
        }
        "electric" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.electric
                    )
                )
            )
        }
        "fairy" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.fairy
                    )
                )
            )
        }
        "fighting" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.fighting
                    )
                )
            )
        }
        "rock" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.rock
                    )
                )
            )
        }
        "ground" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.ground
                    )
                )
            )
        }
        "poison" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.poison
                    )
                )
            )
        }
        "psychic" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.psychic
                    )
                )
            )
        }
        "steel" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.steel
                    )
                )
            )
        }
        "dragon" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.dragon
                    )
                )
            )
        }
        "ice" -> {
            this.setBackgroundColor(
                Color.parseColor(
                    contexto.getString(
                        R.string.ice
                    )
                )
            )
        }


    }





}