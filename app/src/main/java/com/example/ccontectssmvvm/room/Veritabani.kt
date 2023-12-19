package com.example.ccontectssmvvm.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ccontectssmvvm.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani :RoomDatabase() {

    // interfaceye erişim fonksiyonudur
    abstract fun getKisilerDao() : KisilerDao
}