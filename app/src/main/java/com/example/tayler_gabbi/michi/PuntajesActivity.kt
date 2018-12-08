package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_puntajes.*

class PuntajesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntajes)

        ajusteToolbarPuntaje()
    }

    private fun ajusteToolbarPuntaje() {
        setSupportActionBar(toolbar_puntajes)
        title = "LISTA DE PUNTAJES"
    }
}
