package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class HomeActivity : AppCompatActivity() {
    var spiner1 : Spinner? = null
    var spiner2 : Spinner? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        spiner1 = findViewById(R.id.combo_jugador1)
        spiner2 = findViewById(R.id.combo_jugador2)

        var jugadores = arrayOf("ingrese jugador")
        val adapter = ArrayAdapter<String>(this, R.layout.molde_spinner, jugadores)
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiner1!!.adapter = adapter
        spiner2!!.adapter = adapter

    }
}
