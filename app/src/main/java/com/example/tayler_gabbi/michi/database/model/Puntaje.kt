package com.example.tayler_gabbi.michi.database.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Puntaje (
               @PrimaryKey(autoGenerate = true)
               var idP : Long? = null,

               var jugador : String = "",

               var puntaje : Int = 0
)