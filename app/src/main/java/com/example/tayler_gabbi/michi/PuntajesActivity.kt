package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.example.tayler_gabbi.michi.adapter.ListaPuntajesAdapter
import kotlinx.android.synthetic.main.activity_puntajes.*

class PuntajesActivity : AppCompatActivity() {

    var puntajeAdapter : ListaPuntajesAdapter? = null
    var handler :Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntajes)

        puntajeAdapter = ListaPuntajesAdapter()

        my_recyclerview.layoutManager = LinearLayoutManager(this)
        my_recyclerview.adapter = puntajeAdapter

        Thread {
            val lista = MichiApplication.dataBase!!.puntajeDao().listarPuntaje()
            handler.post {
                puntajeAdapter!!.addList(lista)
            }
        }.start()

        ajusteToolbarPuntaje()


    }

    private fun ajusteToolbarPuntaje() {
        setSupportActionBar(toolbar_puntajes)
        title = "LISTA DE PUNTAJES"
    }
}
