package com.example.daggermvvmbase.Repository

import android.content.Context
import android.util.Log
import com.example.daggermvvmbase.base.AppExecutors
import com.example.daggermvvmbase.db.AppDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private var appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    private val context: Context
) {


    private val TAG = "MainRepository"
    fun runNetwork() {
        Log.d(TAG, "runNetwork")
    }

    fun runRoomDB() {
        Log.d(TAG, "runRoomDB")
    }



}