package com.example.tayler_gabbi.michi.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.tayler_gabbi.michi.database.model.Jugador


@Database(entities = [Jugador::class],version = 1)
abstract class MichiDataBase : RoomDatabase(){

    abstract fun jugadorDao() : JugadorDao
}