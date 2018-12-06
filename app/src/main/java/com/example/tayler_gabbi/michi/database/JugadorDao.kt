package com.example.tayler_gabbi.michi.database

import android.arch.persistence.room.*
import com.example.tayler_gabbi.michi.database.model.Jugador


@Dao
interface JugadorDao {

    @Query("select * from Jugador")
    fun listarJugador(): List<Jugador>

    @Insert
    fun insert(jugador: Jugador): Long

    @Insert
    fun insertarListaJugadores(plato : ArrayList<Jugador>) : Array<Long>

    @Delete
    fun deleteJugador(jugador: Jugador):Int

    @Update
    fun updateJugador(jugador: Jugador)
}