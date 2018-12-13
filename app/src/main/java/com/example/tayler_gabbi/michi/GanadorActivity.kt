package com.example.tayler_gabbi.michi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.startActivity

class GanadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganador)

        val background = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep((3*1000).toLong())

                    startActivity<HomeActivity>()

                    finish()
                } catch (e: Exception) {


                    e.printStackTrace()
                }

            }
        }
        background.start()
    }
}
