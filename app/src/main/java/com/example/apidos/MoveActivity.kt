package com.example.apidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MoveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)


        val Mov = getIntent().getExtras()?.getString("ataque")


        Toast.makeText(this,Mov, Toast.LENGTH_SHORT).show()
    }
}
