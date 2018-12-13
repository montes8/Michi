package com.example.tayler_gabbi.michi

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.eddymontesinos.demosqlite_romm.utils.DemoUtils
import com.example.tayler_gabbi.michi.database.model.Puntaje
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.toast
import kotlin.concurrent.thread

class JuegoActivity : AppCompatActivity() {

    var jugador1=ArrayList<Int>()
    var jugador2=ArrayList<Int>()
    var jugadorActivo=1

    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

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
            btnSelecionado.setImageDrawable(DemoUtils.getImage(this,"charli"))
            jugador1.add(idCelda)
            jugadorActivo=2
        }else{
            btnSelecionado.setImageDrawable(DemoUtils.getImage(this,"happy"))
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

                thread (start = true){
                    val dpuntaje = MichiApplication.dataBase!!.puntajeDao().puntajeJugador(jugadorUno)
                    val djugador = MichiApplication.dataBase!!.jugadorDao().datoJugador(jugadorUno)
                     Log.d("jugadorexistente","$jugadorUno")
                    Log.d("jugadordato","${djugador.nombre}")

                   if(dpuntaje != null){
                      val puntajeNuevo = Puntaje()
                       puntajeNuevo.idP = dpuntaje.idP
                       puntajeNuevo.jugador = dpuntaje.jugador
                       puntajeNuevo.puntaje = dpuntaje.puntaje +1
                       MichiApplication.dataBase!!.puntajeDao().updatePuntaje(puntajeNuevo)
                       handler.post {
                           val intent = Intent(this,GanadorActivity::class.java)
                           startActivity(intent)
                       }

                       handler.post { toast("jugador existe") }

                }else{
                        val puntaje = Puntaje()
                       puntaje.idP = djugador.id
                        puntaje.jugador = jugadorUno
                        puntaje.puntaje = 1
                        MichiApplication.dataBase!!.puntajeDao().insert(puntaje)
                        handler.post {
                            val intent = Intent(this,GanadorActivity::class.java)
                            startActivity(intent)
                        }
                    }

                }

            } else {
                thread (start = true){

                        val puntajedos = Puntaje()
                        puntajedos.jugador = jugadorUno
                        puntajedos.puntaje = 1
                        MichiApplication.dataBase!!.puntajeDao().insert(puntajedos)
                        handler.post {
                            Toast.makeText(this, "$jugadorDos ha ganado!!", Toast.LENGTH_LONG).show()
                            val intent = Intent(this,GanadorActivity::class.java)
                            startActivity(intent)
                        }
                    }

                }

            }
        }

}
