package com.cst.proiectaplicatieandroid

import android.app.Application
import androidx.room.Room
import com.cst.proiectaplicatieandroid.data.AppDatabase

class ApplicationController : Application() {

    lateinit var appDatabase: AppDatabase
        private set

    companion object {

        lateinit var instance: ApplicationController
            private set //nu-si va schimba valoarea din alta parte
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        setupDatabase()
    }

    private fun setupDatabase() {
        appDatabase = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "Fotbal"
        ).build()
    }

}