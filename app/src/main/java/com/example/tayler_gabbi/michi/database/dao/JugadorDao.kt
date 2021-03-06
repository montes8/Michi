package com.example.tayler_gabbi.michi.database.dao

import android.arch.persistence.room.*
import com.example.tayler_gabbi.michi.database.model.Jugador


@Dao
interface JugadorDao {

    @Query("select * from Jugador")
    fun listarJugador(): List<Jugador>

    @Query("select * from Jugador where nombre = :jugador")
    fun datoJugador(jugador : String): Jugador

    @Insert
    fun insert(jugador: Jugador): Long

    @Insert
    fun insertarListaJugadores(plato : ArrayList<Jugador>) : Array<Long>

    @Delete
    fun deleteJugador(jugador: Jugador):Int

    @Update
    fun updateJugador(jugador: Jugador)
}