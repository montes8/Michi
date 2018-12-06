package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity

class HomeActivity : AppCompatActivity() ,View.OnClickListener{


    var spiner1 : Spinner? = null
    var spiner2 : Spinner? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        spiner1 = findViewById(R.id.combo_jugador1)
        spiner2 = findViewById(R.id.combo_jugador2)

        var jugadores = arrayOf("ingrese jugador")
        val adapter = ArrayAdapter<String>(this, R.layout.molde_spinner, jugadores)
        adapter.setDropDownViewResource(R.layout.molde_spinner)
        spiner1!!.adapter = adapter
        spiner2!!.adapter = adapter

    }

    override fun onClick(item: View?) {

        when(item){

            btn_agregar_jugador -> startActivity<RegistroActivity>()

            btn_iniciar_partida -> startActivity<RegistroActivity>()

            btn_ver_puntaje -> startActivity<RegistroActivity>()
        }
    }
}
