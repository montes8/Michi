package com.example.tayler_gabbi.michi.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tayler_gabbi.michi.database.dao.JugadorDao
import com.example.tayler_gabbi.michi.database.dao.PuntajeDao
import com.example.tayler_gabbi.michi.database.model.Jugador
import com.example.tayler_gabbi.michi.database.model.Puntaje


@Database(entities = [Jugador::class,Puntaje::class],version = 1)
abstract class MichiDataBase : RoomDatabase(){

    abstract fun jugadorDao() : JugadorDao

    abstract fun puntajeDao() : PuntajeDao
}