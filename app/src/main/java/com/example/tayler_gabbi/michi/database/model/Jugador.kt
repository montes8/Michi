package com.example.tayler_gabbi.michi.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Jugador(

        @PrimaryKey(autoGenerate = true)
        val id : Long? = null,

        val nombre : String = "",

       val puntaje : Int = 0


)