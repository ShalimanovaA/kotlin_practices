package com.angi_sh.secondapp

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context



@Database(entities = [RateEntity::class], version = 1)
abstract class MainDb : RoomDatabase(){
    abstract fun getDao(): Dao

    companion object{
        fun getDB(context: Rate): MainDb{
            return Room.databaseBuilder(
                context.requireContext(),
//                context.applicationContext,
                MainDb::class.java,
                "db.db"
            ).build()
        }
    }
}