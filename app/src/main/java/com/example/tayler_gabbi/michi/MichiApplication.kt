package com.example.tayler_gabbi.michi

import android.app.Application
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import com.example.tayler_gabbi.michi.database.MichiDataBase

class MichiApplication : Application() {

    companion object {

        var dataBase : MichiDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(this,MichiDataBase::class.java,"db_Michi").build()
    }
}