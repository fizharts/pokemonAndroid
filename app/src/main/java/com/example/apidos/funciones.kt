package com.example.apidos

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView


fun Int.multiplicar(numero:Int):Int{
    return this * numero
}



fun RecyclerView.ViewHolder.ponerFondo(color:Int) {

    this.itemView.setBackgroundColor(color)
}