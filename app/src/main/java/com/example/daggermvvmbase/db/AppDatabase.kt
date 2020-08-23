package com.example.daggermvvmbase.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daggermvvmbase.db.Dao.SplashDao
import com.example.daggermvvmbase.db.Model.SplashModel

@Database(entities = [SplashModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Get DAO's
     */

    abstract fun splashDao(): SplashDao

}