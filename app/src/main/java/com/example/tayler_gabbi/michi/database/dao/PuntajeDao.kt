package com.example.tayler_gabbi.michi.database.dao

import android.arch.persistence.room.*
import com.example.tayler_gabbi.michi.database.model.Jugador
import com.example.tayler_gabbi.michi.database.model.Puntaje

@Dao
interface PuntajeDao {

    @Query("select * from Puntaje")
    fun listarPuntaje(): List<Puntaje>


    @Query("select * from Puntaje where jugador = :jugadors")
    fun puntajeJugador(jugadors : String): Puntaje

    @Insert
    fun insert(puntaje: Puntaje): Long

    @Insert
    fun insertarListaPuntajes(puntaje : ArrayList<Puntaje>) : Array<Long>

    @Delete
    fun deletePuntaje(puntaje: Puntaje):Int

    @Update
    fun updatePuntaje(puntaje: Puntaje)
}