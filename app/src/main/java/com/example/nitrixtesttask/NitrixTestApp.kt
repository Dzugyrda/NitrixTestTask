package com.example.nitrixtesttask

import android.app.Application
import com.example.nitrixtesttask.repository.db.DatabaseManager

class NitrixTestApp: Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseManager.initDataBase(this)
    }
}