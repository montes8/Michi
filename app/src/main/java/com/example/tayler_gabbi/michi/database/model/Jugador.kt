package com.example.tayler_gabbi.michi.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Jugador(

        @PrimaryKey(autoGenerate = true)
        var id : Long? = null,

        var nombre : String = ""

)