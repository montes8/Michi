package com.example.tayler_gabbi.michi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_juego.*

class JuegoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)

        ajusteToolbarJuego()
    }

    private fun ajusteToolbarJuego() {
        setSupportActionBar(toolbar_juego)
        title = "EMPIEZA A JUGAR"
    }
}
