package com.example.tayler_gabbi.michi

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_juego.*
import org.jetbrains.anko.defaultSharedPreferences

class JuegoActivity : AppCompatActivity() {

    var jugador1=ArrayList<Int>()
    var jugador2=ArrayList<Int>()
    var jugadorActivo=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        setSupportActionBar(toolbar_Juego)
        toolbar_Juego.title = "SUERTE EN EL JUEGO"

    }



    protected fun btnCliqueado(view: View){

        val btnSelecionado=view as ImageView
        var idCelda=0

        when(btnSelecionado.id){

            R.id.button1 -> idCelda=1
            R.id.button2 -> idCelda=2
            R.id.button3 -> idCelda=3
            R.id.button4 -> idCelda=4
            R.id.button5 -> idCelda=5
            R.id.button6 -> idCelda=6
            R.id.button7 -> idCelda=7
            R.id.button8 -> idCelda=8
            R.id.button9 -> idCelda=9
        }
        partida(idCelda,btnSelecionado)
    }

    fun partida(idCelda:Int,btnSelecionado:ImageView){

        if (jugadorActivo==1){
            btnSelecionado.text="X"
            btnSelecionado.setBackgroundColor(Color.BLUE)
            jugador1.add(idCelda)
            jugadorActivo=2
        }else{
            btnSelecionado.text="O"
            btnSelecionado.setBackgroundColor(Color.GREEN)
            jugador2.add(idCelda)
            jugadorActivo=1
        }
        btnSelecionado.isEnabled=false
        ganador()

    }

    fun ganador() {


        val jugadorUno = defaultSharedPreferences.getString("jugador1","")
        val jugadorDos = defaultSharedPreferences.getString("jugador2","")

        var ganador = -1

        //linea 1
        if (jugador1.contains(1) && jugador1.contains(2) && jugador1.contains(3)) {
            ganador = 1
        }
        if (jugador2.contains(1) && jugador2.contains(2) && jugador2.contains(3)) {
            ganador = 2
        }
        //linea 2
        if (jugador1.contains(4) && jugador1.contains(5) && jugador1.contains(6)) {
            ganador = 1
        }

        if (jugador2.contains(4) && jugador2.contains(5) && jugador2.contains(6)) {
            ganador = 2
        }
        //linea 3
        if (jugador1.contains(7) && jugador1.contains(8) && jugador1.contains(9)) {
            ganador = 1
        }

        if (jugador2.contains(7) && jugador2.contains(8) && jugador2.contains(9)) {
            ganador = 2
        }
        //columna 1
        if(jugador1.contains(1)&&jugador1.contains(4)&&jugador1.contains(7)){
            ganador=1
        }
        if(jugador2.contains(1)&&jugador2.contains(4)&&jugador2.contains(7)) {
            ganador = 2
        }
        //columna 2
        if(jugador1.contains(2)&&jugador1.contains(5)&&jugador1.contains(8)){
            ganador=1
        }
        if(jugador2.contains(2)&&jugador2.contains(5)&&jugador2.contains(8)) {
            ganador = 2
        }
        //columna 3
        if(jugador1.contains(3)&&jugador1.contains(6)&&jugador1.contains(9)){
            ganador=1
        }
        if(jugador2.contains(3)&&jugador2.contains(6)&&jugador2.contains(9)) {
            ganador = 2
        }
        //lina en x 1
        if(jugador1.contains(1)&&jugador1.contains(5)&&jugador1.contains(9)){
            ganador=1
        }
        if(jugador2.contains(1)&&jugador2.contains(5)&&jugador2.contains(9)) {
            ganador = 2
        }
        //linea x 2
        if(jugador1.contains(3)&&jugador1.contains(5)&&jugador1.contains(7)){
            ganador=1
        }
        if(jugador2.contains(3)&&jugador2.contains(5)&&jugador2.contains(7)) {
            ganador = 2
        }

        if (ganador!=-1) {
            if (ganador == 1) {
                Toast.makeText(this, "$jugadorUno ha ganado!!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "$jugadorDos ha ganado!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
