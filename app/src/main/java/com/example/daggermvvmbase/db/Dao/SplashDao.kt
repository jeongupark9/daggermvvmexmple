package com.example.daggermvvmbase.db.Dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import com.example.daggermvvmbase.db.Model.SplashModel

@Dao
interface SplashDao {
    @Update
    fun updateSplash(vararg splashs: SplashModel)
    @Query("SELECT * FROM splashmodel")
    fun loadAllUsers(): Array<SplashModel>
}