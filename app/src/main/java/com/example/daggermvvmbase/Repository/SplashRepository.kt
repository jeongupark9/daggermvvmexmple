package com.example.daggermvvmbase.Repository

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.provider.Settings
import android.util.Log
import com.example.daggermvvmbase.base.AppExecutors
import com.example.daggermvvmbase.db.AppDatabase
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashRepository @Inject constructor(
    private var appDatabase: AppDatabase,
    private val appExecutors: AppExecutors,
    private val context: Context
) {

    @Inject
    lateinit var preferences: SharedPreferences

    private val TAG = "SplashRepository"
    fun runNetwork() {
        Log.d(TAG, "runNetwork")
    }

    fun runRoomDB() {
        Log.d(TAG, "runRoomDB")
    }
    fun setPhoneInfo() : Boolean{
        // 한개라도 세팅이 안되어 있으면 다시 셋팅을 해야함. 그리고 그 결과로 true/false 반환
        if (preferences.getString("ANDROID_ID", "")?.isEmpty()!!
            || preferences.getString("MODEL", "")?.isEmpty()!!
            || preferences.getString("RELEASE", "")?.isEmpty()!!
            || preferences.getString("UUID", "")?.isEmpty()!!
        ) {

          val reuslt : Boolean =   preferences.edit().apply {
                putString("ANDROID_ID", Settings.Secure.ANDROID_ID)
                putString("MODEL", Build.MODEL)
                putString("RELEASE", Build.VERSION.RELEASE.toString())
                putString("UUID", UUID.randomUUID().toString())
            }.run {
                commit()
            }
            return reuslt
        }else{
            // 모두 셋팅 되었기 때문에 ture 반환
            return true
        }
    }


}